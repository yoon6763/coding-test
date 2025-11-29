package baekjoon.bronze.b1

fun main() {
    val visited = mutableSetOf<Pair<Int, Int>>()
    visited.add(0 to 0)
    var (x, y) = 0 to 0
    readln()
    readln().forEach {
        when (it) {
            'S' -> y++
            'N' -> y--
            'E' -> x++
            'W' -> x--
        }
        visited.add(x to y)
    }
    println(visited.size)
}