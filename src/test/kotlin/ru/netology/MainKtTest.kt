package ru.netology
import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun transferComissionMC() {
        val card = "Mastercard"
        val monthTransaction = 0
        val amount = 150000

        val result = transferComission(card, monthTransaction, amount)

        assertEquals("Комиссия: 470 руб." ,result)
    }

    @Test
    fun transferComissionMCmin() {
        val card = "Mastercard"
        val monthTransaction = 0
        val amount = 15000

        val result = transferComission(card, monthTransaction, amount)

        assertEquals("Комиссия: 0 руб." ,result)
    }

    @Test
    fun transferComissionMCmonth() {
        val card = "Mastercard"
        val monthTransaction = 100000
        val amount = 15000

        val result = transferComission(card, monthTransaction, amount)

        assertEquals("Комиссия: 110 руб." ,result)
    }

    @Test
    fun transferComissionVisa() {
        val card = "Visa"
        val monthTransaction = 0
        val amount = 150000

        val result = transferComission(card, monthTransaction, amount)

        assertEquals("Комиссия: 1125 руб." ,result)
    }

    @Test
    fun transferComissionVisaMin() {
        val card = "Visa"
        val monthTransaction = 0
        val amount = 1500

        val result = transferComission(card, monthTransaction, amount)

        assertEquals("Комиссия: 35 руб." ,result)
    }

    @Test
    fun transferComissionMir() {
        val card = "Mir"
        val monthTransaction = 0
        val amount = 150000

        val result = transferComission(card, monthTransaction, amount)

        assertEquals("Комиссия: 0 руб." ,result)
    }
    @Test
    fun transferComissionOver() {
        val card = "Mir"
        val monthTransaction = 0
        val amount = 15000000

        val result = transferComission(card, monthTransaction, amount)

        assertEquals("Превышен лимит переводов" ,result)
    }

    @Test
    fun transferComissionOver2() {
        val card = "Mir"
        val monthTransaction = 15000000
        val amount = 0

        val result = transferComission(card, monthTransaction, amount)

        assertEquals("Превышен лимит переводов" ,result)
    }
}