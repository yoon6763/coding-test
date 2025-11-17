package baekjoon.bronze.b4

fun main() {
    val str = readln()
    println(if (str[0] == '"' && str[str.length - 1] == '"' && str.length > 2) str.substring(1, str.length - 1) else "CE")
}