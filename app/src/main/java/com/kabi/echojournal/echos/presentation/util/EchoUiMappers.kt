package com.kabi.echojournal.echos.presentation.util

import com.kabi.echojournal.echos.domain.echo.Echo
import com.kabi.echojournal.echos.presentation.echos.models.PlayBackState
import com.kabi.echojournal.echos.presentation.models.EchoUi
import com.kabi.echojournal.echos.presentation.models.MoodUi
import kotlin.time.Duration

fun Echo.toEchoUi(
    currentPlaybackDuration: Duration = Duration.ZERO,
    playBackState: PlayBackState = PlayBackState.STOPPED
): EchoUi{
    return EchoUi(
        id = id!!,
        title = title,
        mood = MoodUi.valueOf(mood.name),
        recordedAt = recordedAt,
        note = note,
        topics = topics,
        amplitudes = audioAmplitudes,
        playbackTotalDuration = audioPlaybackLength,
        audioFilePath = audioFilePath,
        playbackCurrentDuration = currentPlaybackDuration,
        playbackState = playBackState
    )
}