package baekjoon.bronze.b4

fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    val origin = Array(r) { readln().toCharArray() }
    readln()
    val parsed = Array(r) { readln().toCharArray() }

    var ans = 0
    repeat(r) { i ->
        repeat(c) { j ->
            if (origin[i][j] == parsed[i][j]) {
                ans++
            }
        }
    }

    println(ans)
}
