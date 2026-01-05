package com.kabi.echojournal.echos.presentation.echos.models

import com.kabi.echojournal.R
import com.kabi.echojournal.core.presentation.util.UiText

data class MoodChipContent(
    val iconsRes: List<Int> = emptyList(),
    val title: UiText = UiText.StringResource(R.string.all_moods)
)