package baekjoon.bronze.b2

fun main() {
    repeat(readln().toInt()) {
        var n = readln().toInt()
        while (true) {
            n++
            if (n.toString().any { it == '0' }) continue
            break
        }
        println(n)
    }
}