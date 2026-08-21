package ru.netology

fun main() {
    val card = "Mastercard"
    val monthTransaction = 0
    val amount = 150000

    println(transferComission(card, monthTransaction, amount))
}

fun transferComission(cardType: String = "Mir", monthTransaction: Int = 0, amount: Int): String {
    val mcComission = 0.006
    val visaComission = 0.0075
    val mcMinComission = 20
    val visaMinComission = 35
    val mcLimit = 75_000
    val dayLimit = 150_000
    val monthLimit = 600_000

    if(amount > dayLimit || (amount + monthTransaction) > monthLimit)
        return ("Превышен лимит переводов")
    else{
        val comisson = when(cardType) {
            "Mastercard" -> {
                if(monthTransaction > mcLimit){
                    (amount * mcComission).toInt() + mcMinComission
                } else if (monthTransaction + amount > mcLimit){
                    ((monthTransaction + amount - mcLimit) * mcComission).toInt() + mcMinComission
                } else 0
            }
            "Visa" -> {
                if (amount * visaComission > visaMinComission)
                    (amount * visaComission).toInt()
                else visaMinComission
            }
            else -> 0
        }
        return("Комиссия: $comisson руб.")
    }
}