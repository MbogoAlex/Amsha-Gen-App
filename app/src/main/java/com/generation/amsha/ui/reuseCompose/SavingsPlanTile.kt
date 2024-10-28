package com.generation.amsha.ui.reuseCompose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.generation.amsha.utils.formatMoneyValue
import com.generation.amsha.utils.screenFontSize
import com.generation.amsha.utils.screenHeight

@Composable
fun SavingsPlanTile(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            Column {
                Text(
                    text = "New Laptop",
                    fontSize = screenFontSize(x = 14.0).sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(screenHeight(x = 4.0)))
                Text(
                    text = "${formatMoneyValue(55.0)} / ${formatMoneyValue(100.0)}",
                    fontSize = screenFontSize(x = 14.0).sp,
                    fontWeight = FontWeight.Thin
                )
            }
        }
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            LinearProgressIndicator(
                progress = { 55f / 100f },
                modifier = Modifier
                    .height(screenHeight(x = 6.0))
                    .clip(CircleShape)
            )
        }
    }
}