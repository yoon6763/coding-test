package baekjoon.bronze.b3

fun main() {
    val a = readln().toBigInteger()
    val oper = readln()
    val b = readln().toBigInteger()
    when (oper) {
        "+" -> println(a + b)
        "*" -> println(a * b)
    }
}