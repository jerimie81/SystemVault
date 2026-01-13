package com.systemvault.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.systemvault.ui.viewmodel.BackupViewModel

@Composable
fun MainScreen(viewModel: BackupViewModel) {
    val state by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    var backupPath by remember { mutableStateOf("/sdcard/SystemVault") }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.onBackupClicked(context, backupPath) }) {
                Text("Backup")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(modifier = Modifier.padding(PaddingValues(0.dp))) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("System Partition Status", style = MaterialTheme.typography.titleMedium)
                    Text(state.storageStatus)
                }
            }

            Card {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Last Backup", style = MaterialTheme.typography.titleMedium)
                    Text(state.lastBackup)
                }
            }

            if (state.isRunning) {
                Card {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Backup Running", style = MaterialTheme.typography.titleMedium)
                        CircularProgressIndicator(modifier = Modifier.padding(top = 8.dp))
                    }
                }
            }

            Card {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Settings", style = MaterialTheme.typography.titleMedium)
                    OutlinedTextField(
                        value = backupPath,
                        onValueChange = { backupPath = it },
                        label = { Text("Backup Path") }
                    )
                    Column(modifier = Modifier.padding(top = 12.dp)) {
                        Text("Exclude /data/media")
                        Switch(
                            checked = state.excludeMedia,
                            onCheckedChange = { viewModel.onExcludeMediaChanged(it) }
                        )
                    }
                    Column(modifier = Modifier.padding(top = 12.dp)) {
                        Text("Exclude /data/cache")
                        Switch(
                            checked = state.excludeCache,
                            onCheckedChange = { viewModel.onExcludeCacheChanged(it) }
                        )
                    }
                }
            }

            LogConsole(lines = state.logs, status = state.statusMessage)
        }
    }
}
