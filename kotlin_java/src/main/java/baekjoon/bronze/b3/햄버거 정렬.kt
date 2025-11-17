package baekjoon.bronze.b3

fun main() {
    when (readLine()!!) {
        "(1)" -> println(0)
        ")1(" -> println(2)
        else -> println(1)
    }
}