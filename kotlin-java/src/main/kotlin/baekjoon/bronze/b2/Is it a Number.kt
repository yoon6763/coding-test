package baekjoon.bronze.b2

fun main() = repeat(readln().toInt()) { println("^\\s*(\\d+)\\s*$".toRegex().matchEntire(readln())?.groupValues?.get(1)?.toBigDecimal() ?: "invalid input") }