package com.generation.amsha.data.transaction

data class UserTransaction(
    val id: Int,
    val createdAt: String,
    val mode: String,
    val amount: Double,
    val transactionType: String
)
