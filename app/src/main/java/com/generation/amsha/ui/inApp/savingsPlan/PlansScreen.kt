package com.generation.amsha.ui.inApp.savingsPlan

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.generation.amsha.ui.reuseCompose.SavingsPlanTile
import com.generation.amsha.ui.theme.AmshaTheme
import com.generation.amsha.utils.screenFontSize
import com.generation.amsha.utils.screenHeight
import com.generation.amsha.utils.screenWidth
import java.time.LocalDateTime

@Composable
fun PlansScreenComposable() {
    Box(
        modifier = Modifier
            .safeDrawingPadding()
    ) {
        PlansScreen()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PlansScreen(
    modifier: Modifier = Modifier
) {
    val currentYear = LocalDateTime.now().year
    var i = 10
    val years = mutableListOf<Int>()

    while(i >= 0) {
        years.add(currentYear - i)
        i--
    }
    
    val stages = listOf("All", "In progress", "Completed")
    var selectedStage by rememberSaveable {
        mutableStateOf("All")
    }


    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = screenWidth(x = 16.0),
                vertical = screenHeight(x = 16.0)
            )
    ) {
        Text(
            text = "Plans",
            fontSize = screenFontSize(x = 16.0).sp,
            fontWeight = FontWeight.Bold
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Card(
                backgroundColor = MaterialTheme.colorScheme.surfaceTint,
                onClick = { /*TODO*/ }
            ) {
                Text(
                    color = MaterialTheme.colorScheme.surface,
                    text = "All time",
                    fontSize = screenFontSize(x = 14.0).sp,
                    modifier = Modifier
                        .padding(
                            vertical = screenWidth(x = 8.0),
                            horizontal = screenWidth(x = 16.0)
                        )
                )
            }
            Spacer(modifier = Modifier.width(screenWidth(x = 4.0)))
            VerticalDivider(
                modifier = Modifier
                    .height(screenHeight(x = 16.0))
            )
            Spacer(modifier = Modifier.width(screenWidth(x = 8.0)))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
            ) {
                years.reversed().forEach {
                    Card(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(
                                end = screenWidth(x = 8.0)
                            )
                    ) {
                        Text(
                            text = it.toString(),
                            fontSize = screenFontSize(x = 14.0).sp,
                            modifier = Modifier
                                .padding(
                                    vertical = screenWidth(x = 8.0),
                                    horizontal = screenWidth(x = 16.0)
                                )
                        )
                    }
                }
            }

        }
        HorizontalDivider()
        Spacer(modifier = Modifier.height(screenHeight(x = 8.0)))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                TextButton(onClick = {
                    expanded = !expanded
                }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = selectedStage)
                        Icon(
                            imageVector = if(expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = "Select stage"
                        )
                    }
                }
                Spacer(modifier = Modifier.height(screenHeight(x = 8.0)))
                Box {
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = !expanded
                        }
                    ) {
                        for(stage in stages) {
                            DropdownMenuItem(
                                text = {
                                    Text(text = stage)
                                },
                                onClick = {
                                    selectedStage = stage
                                    expanded = !expanded
                                }
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            OutlinedButton(onClick = { /*TODO*/ }) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Add plan",
                        fontSize = screenFontSize(x = 14.0).sp
                    )
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add plan")
                }
            }
        }
//        Spacer(modifier = Modifier.height(screenHeight(x = 8.0)))
        LazyColumn {
            items(15) {
                ElevatedCard(
                    modifier = Modifier
                        .padding(
                            top = screenHeight(x = 8.0)
                        )
                ) {
                    SavingsPlanTile(
                        modifier = Modifier
                            .padding(
                                screenWidth(x = 16.0)
                            )
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PlansScreenPreview() {
    AmshaTheme {
        PlansScreen()
    }
}