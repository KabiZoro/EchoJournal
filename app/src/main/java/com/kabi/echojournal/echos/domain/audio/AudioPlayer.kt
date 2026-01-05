package com.kabi.echojournal.echos.domain.audio

import com.kabi.echojournal.echos.domain.audio.model.AudioTrack
import kotlinx.coroutines.flow.StateFlow

interface AudioPlayer {
    val activeTrack: StateFlow<AudioTrack?>
    fun play(filePath: String, onCompletion: () -> Unit)
    fun pause()
    fun resume()
    fun stop()
}