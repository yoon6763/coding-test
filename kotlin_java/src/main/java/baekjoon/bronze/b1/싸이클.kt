package baekjoon.bronze.b1

fun main() {
    val (n, p) = readln().split(" ").map { it.toInt() }
    val visited = ArrayList<Int>()
    visited.add(n)

    var mutableN = n

    while (true) {
        mutableN = (mutableN * n) % p
        if (mutableN in visited) {
            println(visited.size - visited.indexOf(mutableN))
            break
        }
        visited.add(mutableN)
    }
}