package com.kabi.echojournal.echos.presentation.echos.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.kabi.echojournal.R
import com.kabi.echojournal.core.presentation.designsystem.theme.EchoJournalTheme
import com.kabi.echojournal.core.presentation.designsystem.theme.Microphone
import com.kabi.echojournal.core.presentation.designsystem.theme.buttonGradient
import com.kabi.echojournal.core.presentation.designsystem.theme.primary90
import com.kabi.echojournal.core.presentation.designsystem.theme.primary95
import com.kabi.echojournal.echos.presentation.echos.models.rememberBubbleFloatingActionButtonColors

@Composable
fun EchoQuickRecordFloatingActionButton(
    isQuickRecording: Boolean,
    onClick: () -> Unit,
    onLongPressStart: () -> Unit,
    onLongPressEnd: (isCancelled: Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val hapticFeedback = LocalHapticFeedback.current
    val cancelButtonOffset = (-100).dp
    val cancelButtonOffsetPx = with(LocalDensity.current) {
        cancelButtonOffset.toPx()
    }

    var dragOffsetX by remember {
        mutableFloatStateOf(0f)
    }
    var needToHandleLongClickEnd by remember {
        mutableStateOf(false)
    }
    val isWithInCancelThreshold by remember(cancelButtonOffsetPx) {
        derivedStateOf {
            dragOffsetX <= cancelButtonOffsetPx * 0.8f
        }
    }

    LaunchedEffect(isWithInCancelThreshold) {
        if (isWithInCancelThreshold) {
            hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
        }
    }

    val fabPositionOffset by remember {
        derivedStateOf {
            IntOffset(
                x = dragOffsetX.toInt().coerceIn(
                    minimumValue = cancelButtonOffsetPx.toInt(),
                    maximumValue = 0
                ),
                y = 0
            )
        }
    }

    Box(
        modifier = modifier
            .pointerInput(Unit) {
                detectDragGesturesAfterLongPress(
                    onDragStart = {
                        needToHandleLongClickEnd = true
                        hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
                        onLongPressStart()
                    },
                    onDragEnd = {
                        if (needToHandleLongClickEnd) {
                            needToHandleLongClickEnd = false
                            onLongPressEnd(isWithInCancelThreshold)
                            dragOffsetX = 0f
                        }
                    },
                    onDragCancel = {
                        if (needToHandleLongClickEnd) {
                            needToHandleLongClickEnd = false
                            onLongPressEnd(isWithInCancelThreshold)
                            dragOffsetX = 0f
                        }
                    },
                    onDrag = { change, _ ->
                        dragOffsetX += change.positionChange().x
                    }
                )
            },
        contentAlignment = Alignment.Center
    ) {
        if (isQuickRecording) {
            Box(
                modifier = Modifier
                    .offset(x = cancelButtonOffset)
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.errorContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = stringResource(R.string.cancel),
                    tint = MaterialTheme.colorScheme.onErrorContainer
                )
            }
        }

        EchoBubbleFloatingActionButton(
            modifier = Modifier
                .offset { fabPositionOffset },
            showBubble = isQuickRecording,
            onClick = onClick,
            icon = {
                Icon(
                    imageVector = if (isQuickRecording) {
                        Icons.Filled.Microphone
                    } else Icons.Filled.Add,
                    contentDescription = stringResource(R.string.add_new_entry),
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            },
            colors = rememberBubbleFloatingActionButtonColors(
                primary = if (isWithInCancelThreshold) {
                    SolidColor(Color.Red)
                } else MaterialTheme.colorScheme.buttonGradient,
                primaryPressed = MaterialTheme.colorScheme.buttonGradient,
                outerCircle = if (isWithInCancelThreshold) {
                    SolidColor(MaterialTheme.colorScheme.onErrorContainer.copy(0.5f))
                } else SolidColor(MaterialTheme.colorScheme.primary95),
                innerCircle = if (isWithInCancelThreshold) {
                    SolidColor(MaterialTheme.colorScheme.onErrorContainer.copy(0.3f))
                } else SolidColor(MaterialTheme.colorScheme.primary90)
            )
        )
    }
}

@Preview
@Composable
private fun EchoQuickRecordFloatingActionButtonPreview() {
    EchoJournalTheme {
        EchoQuickRecordFloatingActionButton(
            isQuickRecording = true,
            onClick = {},
            onLongPressStart = {},
            onLongPressEnd = {},
            modifier = Modifier
                .fillMaxSize()
        )
    }
}