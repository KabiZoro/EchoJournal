package com.kabi.echojournal.echos.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kabi.echojournal.R
import com.kabi.echojournal.core.presentation.designsystem.theme.EchoJournalTheme
import com.kabi.echojournal.core.presentation.designsystem.theme.Pause
import com.kabi.echojournal.core.presentation.util.defaultShadow
import com.kabi.echojournal.echos.presentation.echos.models.PlayBackState
import com.kabi.echojournal.echos.presentation.models.MoodUi

@Composable
fun EchoPlaybackButton(
    playbackState: PlayBackState,
    onPlayClick: () -> Unit,
    onPauseClick: () -> Unit,
    colors: IconButtonColors,
    modifier: Modifier = Modifier
) {
    FilledIconButton(
        onClick = when (playbackState) {
            PlayBackState.PLAYING -> onPauseClick
            PlayBackState.PAUSED,
            PlayBackState.STOPPED -> onPlayClick
        },
        colors = colors,
        modifier = modifier
            .defaultShadow()
    ) {
        Icon(
            imageVector = when(playbackState){
                PlayBackState.PLAYING -> Icons.Filled.Pause
                PlayBackState.PAUSED,
                PlayBackState.STOPPED -> Icons.Filled.PlayArrow
            },
            contentDescription = when(playbackState){
                PlayBackState.PLAYING -> stringResource(R.string.playing)
                PlayBackState.PAUSED -> stringResource(R.string.paused)
                PlayBackState.STOPPED -> stringResource(R.string.stopped)
            }
        )
    }
}

@Preview
@Composable
private fun EchoPlaybackButtonPreview() {
    EchoJournalTheme {
        EchoPlaybackButton(
            playbackState = PlayBackState.PLAYING,
            onPlayClick = {},
            onPauseClick = {},
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MoodUi.SAD.colorSet.vivid
            )
        )
    }
}