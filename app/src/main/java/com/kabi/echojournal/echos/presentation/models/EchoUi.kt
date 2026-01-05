package com.kabi.echojournal.echos.presentation.models

import com.kabi.echojournal.echos.presentation.echos.models.PlayBackState
import com.kabi.echojournal.echos.presentation.util.toReadableTime
import java.time.Instant as JavaInstant
import kotlin.time.Duration

data class EchoUi(
    val id: Int,
    val title: String,
    val mood: MoodUi,
    val recordedAt: JavaInstant,
    val note: String?,
    val topics: List<String>,
    val amplitudes: List<Float>,
    val playbackTotalDuration: Duration,
    val audioFilePath: String,
    val playbackCurrentDuration: Duration = Duration.ZERO,
    val playbackState: PlayBackState = PlayBackState.STOPPED
){
    val formattedRecordedAt = recordedAt.toReadableTime()
    val playbackRatio = (playbackCurrentDuration / playbackTotalDuration).toFloat()
}
