package com.generation.amsha.ui.inApp.dashboard

import android.app.DatePickerDialog
import android.os.Build
import android.widget.Toast
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.generation.amsha.R
import com.generation.amsha.data.transaction.UserTransaction
import com.generation.amsha.ui.inApp.chart.BarChart
import com.generation.amsha.ui.theme.AmshaTheme
import com.generation.amsha.utils.dateFormatter
import com.generation.amsha.utils.formatIsoDateTime2
import com.generation.amsha.utils.formatMoneyValue
import com.generation.amsha.utils.screenFontSize
import com.generation.amsha.utils.screenHeight
import com.generation.amsha.utils.screenWidth
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId

@RequiresApi(Build.VERSION_CODES.O)
val transactions = listOf(
    UserTransaction(
        id = 1,
        createdAt = formatIsoDateTime2(LocalDateTime.parse("2024-10-16T10:45:31.713285")),
        mode = "M-PESA",
        amount = 100.0,
        transactionType = "Deposit"
    ),
    UserTransaction(
        id = 2,
        createdAt = formatIsoDateTime2(LocalDateTime.parse("2024-10-17T09:15:22.123456")),
        mode = "M-PESA",
        amount = 150.0,
        transactionType = "Withdrawal"
    ),
    UserTransaction(
        id = 3,
        createdAt = formatIsoDateTime2(LocalDateTime.parse("2024-10-18T13:00:05.987654")),
        mode = "M-PESA",
        amount = 200.0,
        transactionType = "Deposit"
    ),
    UserTransaction(
        id = 4,
        createdAt = formatIsoDateTime2(LocalDateTime.parse("2024-10-19T14:30:45.654321")),
        mode = "M-PESA",
        amount = 120.0,
        transactionType = "Deposit"
    ),
    UserTransaction(
        id = 5,
        createdAt = formatIsoDateTime2(LocalDateTime.parse("2024-10-20T17:45:12.000000")),
        mode = "M-PESA",
        amount = 80.0,
        transactionType = "Payment"
    ),
    UserTransaction(
        id = 6,
        createdAt = formatIsoDateTime2(LocalDateTime.parse("2024-10-21T20:00:45.567890")),
        mode = "M-PESA",
        amount = 60.0,
        transactionType = "Deposit"
    ),
    UserTransaction(
        id = 7,
        createdAt = formatIsoDateTime2(LocalDateTime.parse("2024-10-22T08:30:22.111111")),
        mode = "M-PESA",
        amount = 170.0,
        transactionType = "Transfer"
    ),
    UserTransaction(
        id = 8,
        createdAt = formatIsoDateTime2(LocalDateTime.parse("2024-10-23T16:15:33.222222")),
        mode = "M-PESA",
        amount = 130.0,
        transactionType = "Withdrawal"
    ),
    UserTransaction(
        id = 9,
        createdAt = formatIsoDateTime2(LocalDateTime.parse("2024-10-24T19:30:44.333333")),
        mode = "M-PESA",
        amount = 110.0,
        transactionType = "Deposit"
    ),
    UserTransaction(
        id = 10,
        createdAt = formatIsoDateTime2(LocalDateTime.parse("2024-10-25T21:45:55.444444")),
        mode = "M-PESA",
        amount = 90.0,
        transactionType = "Payment"
    )
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier
) {

    val transactionsFilterParam by rememberSaveable {
        mutableStateOf("All transactions")
    }

    var filteringTransactions by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = screenWidth(x = 16.0),
                vertical = screenHeight(x = 16.0)
            )
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Account Balance",
            fontWeight = FontWeight.Bold,
            fontSize = screenFontSize(x = 14.0).sp
        )
        Spacer(modifier = Modifier.height(screenHeight(x = 8.0)))
        Text(
            text = formatMoneyValue(1545.0),
            fontWeight = FontWeight.Bold,
            fontSize = screenFontSize(x = 18.0).sp
        )
        Spacer(modifier = Modifier.height(screenHeight(x = 8.0)))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = { filteringTransactions = !filteringTransactions }) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = transactionsFilterParam)
                    Icon(
                        imageVector = if(filteringTransactions) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = transactionsFilterParam
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            TextButton(onClick = { /*TODO*/ }) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "See all")
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "See all"
                )
            }
        }
        }
//        Spacer(modifier = Modifier.height(screenHeight(x = 8.0)))
        DateRangePicker(
            startDate = LocalDate.now().minusMonths(1),
            endDate = LocalDate.now(),
            defaultStartDate = null,
            defaultEndDate = null,
            onChangeStartDate = {},
            onChangeLastDate = {}
        )
        Spacer(modifier = Modifier.height(screenHeight(x = 8.0)))
        BarChart(
            transactions = transactions,
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight(x = 250.0))
        )
        Spacer(modifier = Modifier.height(screenHeight(x = 8.0)))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                shape = RoundedCornerShape(screenWidth(x = 2.0)),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceTint
                ),
                modifier = Modifier
                    .size(screenWidth(x = 20.0))
            ) {
                
            }
            Spacer(modifier = Modifier.width(screenWidth(x = 2.0)))
            Text(
                text = "Deposit",
                fontSize = screenFontSize(x = 12.0).sp
            )
            Spacer(modifier = Modifier.width(screenWidth(x = 8.0)))
            Text(
                color = MaterialTheme.colorScheme.surfaceTint,
                text = formatMoneyValue(2550.0),
                fontSize = screenFontSize(x = 12.0).sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(screenHeight(x = 8.0)))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                shape = RoundedCornerShape(screenWidth(x = 2.0)),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.error
                ),
                modifier = Modifier
                    .size(screenWidth(x = 20.0))
            ) {

            }
            Spacer(modifier = Modifier.width(screenWidth(x = 2.0)))
            Text(
                text = "Withdrawal",
                fontSize = screenFontSize(x = 12.0).sp
            )
            Spacer(modifier = Modifier.width(screenWidth(x = 8.0)))
            Text(
                color = MaterialTheme.colorScheme.error,
                text = formatMoneyValue(2550.0),
                fontSize = screenFontSize(x = 12.0).sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(screenHeight(x = 16.0)))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Savings Plans",
                fontSize = screenFontSize(x = 18.0).sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.weight(1f))
            TextButton(onClick = { /*TODO*/ }) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "More",
                        fontSize = screenFontSize(x = 14.0).sp
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "More"
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(screenHeight(x = 8.0)))
        SavingsPlanTile()
        Spacer(modifier = Modifier.height(screenHeight(x = 8.0)))
        SavingsPlanTile()
        Spacer(modifier = Modifier.height(screenHeight(x = 8.0)))
        SavingsPlanTile()
        Spacer(modifier = Modifier.height(screenHeight(x = 8.0)))
        SavingsPlanTile()
        Spacer(modifier = Modifier.height(screenHeight(x = 8.0)))
        SavingsPlanTile()
        Spacer(modifier = Modifier.height(screenHeight(x = 8.0)))
        SavingsPlanTile()
    }
}

@Composable
fun SavingsPlanTile(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateRangePicker(
    startDate: LocalDate,
    endDate: LocalDate,
    defaultStartDate: String?,
    defaultEndDate: String?,
    onChangeStartDate: (date: LocalDate) -> Unit,
    onChangeLastDate: (date: LocalDate) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    // Parse the default start and end dates
    val defaultStartLocalDate = defaultStartDate?.let { LocalDate.parse(it) }
    val defaultEndLocalDate = defaultEndDate?.let { LocalDate.parse(it) }

    // Convert LocalDate to milliseconds since epoch
    val defaultStartMillis = defaultStartLocalDate?.atStartOfDay(ZoneId.systemDefault())?.toInstant()?.toEpochMilli()
    val defaultEndMillis = defaultEndLocalDate?.atStartOfDay(ZoneId.systemDefault())?.toInstant()?.toEpochMilli()

    val oneMonthAgo = LocalDateTime.now().minusMonths(1)

    @RequiresApi(Build.VERSION_CODES.O)
    fun showDatePicker(isStart: Boolean) {
        val initialDate = if (isStart) startDate else endDate
        val datePicker = DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                val selectedDate = LocalDate.of(year, month + 1, dayOfMonth)
                if (isStart) {
                    if (selectedDate.isBefore(endDate) || selectedDate.isEqual(endDate)) {
                        onChangeStartDate(selectedDate)
                    } else {
                        // Handle case where start date is after end date
                        Toast.makeText(context, "Start date must be before end date", Toast.LENGTH_LONG).show()
                    }
                } else {
                    if (selectedDate.isAfter(startDate) || selectedDate.isEqual(startDate)) {
                        onChangeLastDate(selectedDate)
                    } else {
                        // Handle case where end date is before start date
                        Toast.makeText(context, "End date must be after start date", Toast.LENGTH_LONG).show()
                    }
                }
            },

            initialDate.year,
            initialDate.monthValue - 1,
            initialDate.dayOfMonth
        )

        // Set minimum and maximum dates
        defaultStartMillis?.let { datePicker.datePicker.minDate = it }
        defaultEndMillis?.let { datePicker.datePicker.maxDate = it }

        datePicker.show()
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        ),
        elevation = CardDefaults.elevatedCardElevation(screenWidth(x = 10.0)),
        modifier = modifier
//            .padding(screenWidth(x = 16.0))
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            IconButton(onClick = { showDatePicker(true) }) {
                Icon(
                    tint = MaterialTheme.colorScheme.surfaceTint,
                    painter = painterResource(id = R.drawable.calendar),
                    contentDescription = null
                )
            }
            Text(text = dateFormatter.format(startDate))
            Text(
                text = "to",
                fontSize = screenFontSize(x = 14.0).sp
            )

            Text(
                text = dateFormatter.format(endDate),
                fontSize = screenFontSize(x = 14.0).sp
            )
            IconButton(onClick = { showDatePicker(false) }) {
                Icon(
                    tint = MaterialTheme.colorScheme.surfaceTint,
                    painter = painterResource(id = R.drawable.calendar),
                    contentDescription = null,
                    modifier = Modifier
                        .size(screenWidth(x = 24.0))
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardScreenPreview() {
    AmshaTheme {
        DashboardScreen()
    }
}