package baekjoon.bronze.b3

fun main() {
    repeat(3) {
        val n = readln().toInt()
        var bigInteger = 0.toBigInteger()
        repeat(n) {
            bigInteger += readln().toBigInteger()
        }
        if (bigInteger > 0.toBigInteger()) println("+")
        else if (bigInteger < 0.toBigInteger()) println("-")
        else println("0")
    }
}