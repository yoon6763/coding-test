package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val a = readln().split(" ").map { it.toInt() }
    val b = readln().split(" ").map { it.toInt() }

    val sumA = a[0] * 1 + a[1] * 2 + a[2] * 3 + a[3] * 3 + a[4] * 4 + a[5] * 10
    val sumB = b[0] * 1 + b[1] * 2 + b[2] * 2 + b[3] * 2 + b[4] * 3 + b[5] * 5 + b[6] * 10

    when {
        sumA > sumB -> println("Battle ${it + 1}: Good triumphs over Evil")
        sumA < sumB -> println("Battle ${it + 1}: Evil eradicates all trace of Good")
        else -> println("Battle ${it + 1}: No victor on this battle field")
    }
}
