package com.example.prayercounter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PrayerCounterRow(
    prayerType: PrayerType,
    value: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
//            .fillMaxHeight(),
            .height(68.dp), // Gives a large tap area for clarity.
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Big Decrement Button (fills most of the row)
        Button(
            onClick = onDecrement,
            modifier = Modifier
                .weight(0.5f)
//                .fillMaxHeight(),
                .height(56.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "-",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.width(12.dp))

        // Current Counter Value + Prayer Name
        Column(
            modifier = Modifier
                .weight(0.28f)
                .padding(horizontal = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = value.toString(),
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = prayerType.displayName,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Spacer(modifier = Modifier.width(12.dp))

        // Small Increment Button
        OutlinedButton(
            onClick = onIncrement,
            modifier = Modifier
                .weight(0.22f)
                .height(36.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color(0xFFe3f2fd))
        ) {
            Text(
                text = "+",
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF1976D2)
            )
        }
    }
}
