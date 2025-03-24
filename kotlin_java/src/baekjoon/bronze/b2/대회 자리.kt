package baekjoon.bronze.b2

fun main() {
    repeat(readln().toInt()) {
        val (p, m) = readln().split(" ").map { it.toInt() }
        val visited = Array(m + 1) { false }
        var cnt = 0
        repeat(p) {
            val num = readln().toInt()
            if (visited[num]) cnt++
            else visited[num] = true
        }

        println(cnt)
    }
}