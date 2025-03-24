package baekjoon.bronze.b3

fun main() {
    val (sample, system) = readln().split(" ").map { it.toInt() }
    var samf = false
    var sysf = false

    repeat(sample) {
        val (ans, input) = readln().split(" ").map { it.toInt() }
        if (ans != input) samf = true
    }

    repeat(system) {
        val (ans, input) = readln().split(" ").map { it.toInt() }
        if (ans != input) sysf = true
    }

    when {
        samf.not() && sysf -> println("Why Wrong!!!")
        samf.not() && sysf.not() -> println("Accepted")
        else -> println("Wrong Answer")
    }
}