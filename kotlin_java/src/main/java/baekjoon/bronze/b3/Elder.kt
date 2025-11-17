package baekjoon.bronze.b3

fun main() {
    val cur = readln()[0]
    var current = cur
    val visited = BooleanArray(128)
    visited[current.code] = true

    repeat(readln().toInt()) {
        val (x, y) = readLine()!!.split(" ").map { it[0] }
        if (y == current) {
            visited[x.code] = true
            current = x
        }
    }

    var cnt = 0
    for (c in 'A'..'Z') {
        if (visited[c.code]) cnt++
    }

    println(current)
    println(cnt)
}
