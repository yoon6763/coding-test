package baekjoon.bronze.b4

fun main() {
    val n = -(readln().toInt() - readln().toInt())
    if (n <= 0) {
        println("Congratulations, you are within the speed limit!")
        return
    }
    println(
        "You are speeding and your fine is $${
            when (n) {
                in 1..20 -> 100
                in 21..30 -> 270
                else -> 500
            }
        }."
    )
}
