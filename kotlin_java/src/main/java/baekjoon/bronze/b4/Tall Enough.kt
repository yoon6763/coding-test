package baekjoon.bronze.b4

fun main() {
    var ans = true

    repeat(readln().toInt()) {
        val h = readln().toInt()
        if (h < 48) {
            ans = false
        }
    }

    println(if (ans) "True" else "False")
}