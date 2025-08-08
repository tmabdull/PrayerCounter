package com.example.prayercounter

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.bundleOf

@Composable
fun PrayerCounterApp() {
    // Temporary state. Replace this with storage-backed state later.
    val initial = PrayerType.entries.associateWith { 0 }
    var counterMap by remember { mutableStateOf(initial) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            PrayerType.entries.forEach { type ->
                PrayerCounterRow(
                    prayerType = type,
                    value = counterMap[type] ?: 0,
                    onIncrement = {
                        counterMap = counterMap.toMutableMap().also {
                            it[type] = (it[type] ?: 0) + 1
                        }
                    },
                    onDecrement = {
                        counterMap = counterMap.toMutableMap().also {
                            val curr = (it[type] ?: 0)
                            if (curr > 0) it[type] = curr - 1
                        }
                    }
                )
                Spacer(modifier = Modifier.height(12.dp))
            }

            // Placeholder for future: Log Screen Button
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                OutlinedButton(onClick = { /* TODO: navigate to logs */ }) {
                    Text("Logs")
                }
            }
        }
    }
}
