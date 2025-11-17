package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    val password = readln()
    var need = 0
    if (!password.any { it.isDigit() }) need++
    if (!password.any { it.isLowerCase() }) need++
    if (!password.any { it.isUpperCase() }) need++
    if (!password.any { it in "!@#$%^&*()-+".toCharArray() }) need++
    println(maxOf(need, 6 - n))
}
