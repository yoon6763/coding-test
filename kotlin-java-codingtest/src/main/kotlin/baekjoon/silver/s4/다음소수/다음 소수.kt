package baekjoon.silver.s4.다음소수

fun main() = repeat(readln().toInt()) {
    val bigInteger = readln().toBigInteger()
    if (bigInteger.isProbablePrime(10)) println(bigInteger)
    else println(bigInteger.nextProbablePrime())
}