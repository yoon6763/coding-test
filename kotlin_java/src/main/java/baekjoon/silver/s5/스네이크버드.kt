package baekjoon.silver.s5

fun main() {
    var (n, m) = readln().split(" ").map { it.toInt() }
    readln().split(" ").map { it.toInt() }.sorted().forEach {
        if (m < it) {
            println(m)
            return
        }
        m++
    }
    println(m)
}