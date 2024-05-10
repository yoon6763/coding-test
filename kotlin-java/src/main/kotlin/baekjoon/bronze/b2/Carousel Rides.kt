package baekjoon.bronze.b2

fun main() {
    while (true) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) break

        var ansPricePerTicket = Int.MAX_VALUE.toDouble()
        var ansTicket = 0
        var ansPrice = 0

        repeat(n) {
            val (countOfTicket, price) = readln().split(" ").map { it.toDouble() }
            if (countOfTicket > m) {
                return@repeat
            }

            val pricePerTicket = price / countOfTicket
            if (pricePerTicket < ansPricePerTicket) {
                ansPricePerTicket = pricePerTicket
                ansTicket = countOfTicket.toInt()
                ansPrice = price.toInt()
            } else if (pricePerTicket == ansPricePerTicket && countOfTicket > ansTicket) {
                ansTicket = countOfTicket.toInt()
                ansPrice = price.toInt()
            }
        }

        if (ansPricePerTicket == Int.MAX_VALUE.toDouble()) {
            println("No suitable tickets offered")
        } else {
            println("Buy $ansTicket tickets for $$ansPrice")
        }
    }
}
