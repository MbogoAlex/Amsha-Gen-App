package com.generation.amsha.data.transaction

import kotlinx.serialization.Serializable

@Serializable
data class TransactionResponseBody (
    val statusCode: Int,
    val message: String,
    val data: TransactionResponseBodyData
)

@Serializable
data class TransactionResponseBodyData(
    val transaction: TransactionResponseBodyDataTransaction
)

@Serializable
data class TransactionResponseBodyDataTransaction(
    val id: Int,
    val createdAt: String,
    val mode: String,
    val amount: Double,
    val user: TransactionResponseBodyDataTransactionUser,
    val transactionType: String
)

@Serializable
data class TransactionResponseBodyDataTransactionUser(
    val id: Int,
    val fullName: String,
    val email: String,
    val phoneNumber: String,
    val profilePic: String?,
    val createdAt: String,
    val archivedAt: String?,
    val role: String,
    val accountBalance: Double,
    val blogs: Int,
    val comments: Int,
    val transactions: Int,
    val archived: Boolean
)