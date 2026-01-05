package com.kabi.echojournal.echos.domain.echo

import java.time.Instant
import kotlin.time.Duration

data class Echo(
    val title: String,
    val mood: Mood,
    val topics: List<String>,
    val recordedAt: Instant,
    val note: String?,
    val audioFilePath: String,
    val audioPlaybackLength: Duration,
    val audioAmplitudes: List<Float>,
    val id: Int? = null
)
