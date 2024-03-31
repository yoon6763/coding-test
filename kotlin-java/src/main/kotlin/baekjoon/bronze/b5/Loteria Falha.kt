package baekjoon.bronze.b5

fun main() {
    while (true) {
        val n = readln().toBigInteger()
        if (n == 0.toBigInteger()) break
        if (n % 42.toBigInteger() == 0.toBigInteger()) println("PREMIADO")
        else println("TENTE NOVAMENTE")
    }
}
