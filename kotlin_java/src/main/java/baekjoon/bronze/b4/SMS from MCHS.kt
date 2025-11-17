package baekjoon.bronze.b4

fun main() {
    val (t1, v1) = readln().split(" ").map { it.toInt() }
    val (t2, v2) = readln().split(" ").map { it.toInt() }
    if (t2 < 0 && v2 >= 10) {
        println("A storm warning for tomorrow! Be careful and stay home if possible!")
        return
    }
    if (t1 > t2) {
        println("MCHS warns! Low temperature is expected tomorrow.")
        return
    }
    if (v1 < v2) {
        println("MCHS warns! Strong wind is expected tomorrow.")
        return
    }
    println("No message")
}
