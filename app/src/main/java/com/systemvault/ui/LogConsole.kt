package com.systemvault.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LogConsole(lines: List<String>, status: String) {
    Card {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .heightIn(max = 200.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text("Status", style = MaterialTheme.typography.titleMedium)
            Text(status)
            if (lines.isNotEmpty()) {
                Text("Logs", style = MaterialTheme.typography.titleMedium)
                lines.takeLast(10).forEach { line ->
                    Text(line, style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}
