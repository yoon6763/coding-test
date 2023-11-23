package baekjoon.bronze.b2

fun main() {
    val sb = StringBuilder()

    val n = readln().toInt()

    if (n == 1) {
        println("*")
        return
    }

    repeat(n * 2) {
        if (it % 2 == 0) {
            repeat(n) {
                if (it % 2 == 0) sb.append("*")
                else sb.append(" ")
            }
        } else {
            repeat(n) {
                if (it % 2 == 0) sb.append(" ")
                else sb.append("*")
            }
        }
        sb.append("\n")
    }

    println(sb)
}