package com.kabi.echojournal.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.kabi.echojournal.app.navigation.NavigationRoot
import com.kabi.echojournal.core.presentation.designsystem.theme.EchoJournalTheme

// root package -> feature package -> layer package -> component package

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EchoJournalTheme {
                NavigationRoot(
                    navController = rememberNavController()
                )
            }
        }
    }
}
