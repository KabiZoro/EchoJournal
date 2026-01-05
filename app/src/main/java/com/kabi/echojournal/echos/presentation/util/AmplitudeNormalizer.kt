package com.kabi.echojournal.echos.presentation.util

import kotlin.math.roundToInt

object AmplitudeNormalizer {

    private const val AMPLITUDE_MIN_OUTPUT_THRESHOLD = 0.1f
    private const val MIN_OUTPUT = 0.25f
    private const val MAX_OUTPUT = 1f

    fun normalize(
        sourceAmplitudes: List<Float>,
        trackWidth: Float,
        barWidth: Float,
        spacing: Float
    ): List<Float> {
        require(trackWidth >= 0f) {
            "Track width must be positive"
        }
        require(trackWidth >= barWidth + spacing) {
            "Track width must be at least the size of one bar and spacing"
        }
        if (sourceAmplitudes.isEmpty()) {
            return emptyList()
        }
        val barsCount = (trackWidth / (barWidth + spacing)).roundToInt()
        val resampled = resampledAmplitudes(sourceAmplitudes, barsCount)
        val remapped = remapAmplitudes(resampled)

        return remapped
    }

    private fun remapAmplitudes(resampled: List<Float>): List<Float> {
        val outputRange = MAX_OUTPUT - MIN_OUTPUT
        val scaleFactor = MAX_OUTPUT - AMPLITUDE_MIN_OUTPUT_THRESHOLD
        return resampled.map { amplitude ->
            if (amplitude <= AMPLITUDE_MIN_OUTPUT_THRESHOLD) {
                MIN_OUTPUT
            } else {
                val amplitudeRange = amplitude - AMPLITUDE_MIN_OUTPUT_THRESHOLD

                MIN_OUTPUT + (amplitudeRange * outputRange / scaleFactor)

            }
        }
    }

    private fun resampledAmplitudes(
        sourceAmplitudes: List<Float>,
        targetSize: Int
    ): List<Float> {
        return when {
            targetSize == sourceAmplitudes.size -> sourceAmplitudes
            targetSize < sourceAmplitudes.size -> downSample(sourceAmplitudes, targetSize)
            else -> upSample(sourceAmplitudes, targetSize)
        }
    }

    private fun downSample(
        source: List<Float>,
        targetSize: Int
    ): List<Float> {
        val ratio = source.size.toFloat() / targetSize
        return List(targetSize) { index ->
            val start = (index * ratio).toInt()
            val end = ((index + 1) * ratio).toInt().coerceAtMost(source.size)
            source.subList(start, end).max()
        }
    }

    private fun upSample(
        source: List<Float>,
        targetSize: Int
    ): List<Float> {
        val result = mutableListOf<Float>()
        val step = (source.size - 1).toFloat() / (targetSize - 1)
        for (i in 0 until targetSize) {
            val position = i * step
            val index = position.toInt()
            val fraction = position - index
            val value = if (index + 1 < source.size) {
                source[index] * (1 - fraction) + source[index + 1] * fraction
            } else {
                source[index]
            }
            result.add(value)
        }
        return result
    }
}