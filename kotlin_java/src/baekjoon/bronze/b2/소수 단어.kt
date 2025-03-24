package baekjoon.bronze.b2

fun main() {
    val input =
        readln().toCharArray().sumOf { if (it.isUpperCase()) (it - 'A' + 27).toInt() else (it - 'a' + 1).toInt() }

    if (input <= 2) {
        println("It is a prime word.")
        return
    }

    var isPrime = true
    for (i in 2..<input) {
        if (input % i == 0) {
            isPrime = false
            break
        }
    }

    println(if (isPrime) "It is a prime word." else "It is not a prime word.")
}