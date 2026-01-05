package com.kabi.echojournal.echos.presentation.echos.models

import com.kabi.echojournal.core.presentation.util.UiText
import com.kabi.echojournal.echos.presentation.models.EchoUi

data class EchoDaySection(
    val dateHeader: UiText,
    val echo: List<EchoUi>
)
