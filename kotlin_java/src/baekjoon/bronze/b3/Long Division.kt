package baekjoon.bronze.b3

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val a = readln().toBigInteger()
        val b = readln().toBigInteger()

        if (it != 0) println()

        println(a.divide(b))
        println(a.mod(b))
    }
}
