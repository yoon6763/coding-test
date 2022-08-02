package baekjoon.bronze.b5

fun main() {
    val submit = Array(30) { false }
    repeat(28) {
        submit[readLine()!!.toInt() - 1] = true
    }

    for (i in 0 until 30) {
        if (!submit[i])
            println(i + 1)
    }
}