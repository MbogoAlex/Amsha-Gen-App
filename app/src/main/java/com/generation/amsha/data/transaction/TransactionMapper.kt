package com.generation.amsha.data.transaction

import android.os.Build
import androidx.annotation.RequiresApi
import com.generation.amsha.utils.formatIsoDateTime
import com.generation.amsha.utils.formatIsoDateTime2
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
fun TransactionResponseBodyDataTransaction.toUserTransaction(): UserTransaction = UserTransaction(
    id = id,
    createdAt = formatIsoDateTime2(LocalDateTime.parse(createdAt)),
    mode = mode,
    amount = amount,
    transactionType = transactionType
)

