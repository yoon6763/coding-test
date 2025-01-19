package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    val visited = BooleanArray(n + 1)
    readln().split(" ").map { it.toInt() }.forEach {
        if (it !in 1..n || visited[it]) {
            println("NIE")
            return
        }
        visited[it] = true
    }
    println("TAK")
}