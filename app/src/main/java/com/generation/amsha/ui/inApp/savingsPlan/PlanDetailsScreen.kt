package com.generation.amsha.ui.inApp.savingsPlan

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.generation.amsha.ui.theme.AmshaTheme
import com.generation.amsha.utils.formatIsoDateTime2
import com.generation.amsha.utils.formatMoneyValue
import com.generation.amsha.utils.screenFontSize
import com.generation.amsha.utils.screenHeight
import com.generation.amsha.utils.screenWidth
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PlanDetailsScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                vertical = screenHeight(x = 16.0),
                horizontal = screenWidth(x = 16.0)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Previous screen"
            )
            Text(
                text = "Savings Plan",
                fontWeight = FontWeight.Bold,
                fontSize = screenFontSize(x = 14.0).sp,
            )
            Box {

            }
        }
        Spacer(modifier = Modifier.height(screenHeight(x = 8.0)))
        Text(
            text = "Laptop for Graduation",
            fontWeight = FontWeight.Bold,
            fontSize = screenFontSize(x = 16.0).sp
        )
        Spacer(modifier = Modifier.height(screenHeight(x = 16.0)))
        Text(text = "I'm saving for a new laptop and accessories before graduation.")
        Spacer(modifier = Modifier.height(screenHeight(x = 16.0)))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Created",
                fontSize = screenFontSize(x = 14.0).sp,
                color = MaterialTheme.colorScheme.surfaceTint
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = formatIsoDateTime2(LocalDateTime.now()),
                fontSize = screenFontSize(x = 14.0).sp,
            )
        }
        Spacer(modifier = Modifier.height(screenHeight(x = 16.0)))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Updated",
                fontSize = screenFontSize(x = 14.0).sp,
                color = MaterialTheme.colorScheme.surfaceTint
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = formatIsoDateTime2(LocalDateTime.now()),
                fontSize = screenFontSize(x = 14.0).sp,
            )
        }
        Spacer(modifier = Modifier.height(screenHeight(x = 16.0)))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Target",
                fontSize = screenFontSize(x = 14.0).sp,
                color = MaterialTheme.colorScheme.surfaceTint
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = formatIsoDateTime2(LocalDateTime.now()),
                fontSize = screenFontSize(x = 14.0).sp,
            )
        }
        Spacer(modifier = Modifier.height(screenHeight(x = 16.0)))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Total",
                fontSize = screenFontSize(x = 14.0).sp,
                color = MaterialTheme.colorScheme.surfaceTint
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = formatMoneyValue(2500.0),
                fontSize = screenFontSize(x = 14.0).sp,
            )
        }
        Spacer(modifier = Modifier.height(screenHeight(x = 24.0)))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Progress",
                fontSize = screenFontSize(x = 14.0).sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = formatMoneyValue(750.0),
                fontSize = screenFontSize(x = 14.0).sp,
            )
        }
        Spacer(modifier = Modifier.height(screenHeight(x = 8.0)))
        LinearProgressIndicator(
            progress = { 750f / 2500f },
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight(x = 8.0))
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(screenHeight(x = 16.0)))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = "Deposit",
                    fontSize = screenFontSize(x = 14.0).sp
                )
            }
            Spacer(modifier = Modifier.width(screenWidth(x = 4.0)))
            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = "Edit",
                    fontSize = screenFontSize(x = 14.0).sp
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.error
            ),
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Delete plan",
                fontSize = screenFontSize(x = 14.0).sp
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PlanDetailsScreenPreview() {
    AmshaTheme {
        PlanDetailsScreen()
    }
}