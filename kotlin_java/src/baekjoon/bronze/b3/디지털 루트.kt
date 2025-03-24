package baekjoon.bronze.b3

fun main() {
    while (true) {
        var n = readln()
        if (n == "0") break
        while (n.length > 1) n = n.map { it - '0' }.sum().toString()
        println(n)
    }
}