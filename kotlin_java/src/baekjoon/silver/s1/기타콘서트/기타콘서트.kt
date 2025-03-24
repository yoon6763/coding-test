package baekjoon.silver.s1.`기타콘서트`

lateinit var arr: LongArray
lateinit var answer: IntArray
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    arr = LongArray(n) {
        val music = readLine().split(" ")[1]
        music.map { if (it == 'Y') '1' else '0' }.joinToString("").toLong(2)
    }

    answer = IntArray(m + 1) { Int.MAX_VALUE }

    dfs(0, 0, 0)

    println(if (answer.count { it != Int.MAX_VALUE && it != 0 } == 0) -1 else answer.last { it != Int.MAX_VALUE })
}

fun dfs(index: Int, depth: Int, ableMusic: Long) {
    val bitCount = ableMusic.countOneBits()

    answer[bitCount] = minOf(answer[bitCount], depth)

    if (index == n) return

    dfs(index + 1, depth + 1, ableMusic or arr[index])
    dfs(index + 1, depth, ableMusic)
}