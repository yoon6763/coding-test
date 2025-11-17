package baekjoon.gold.g4.`가르침`

lateinit var words: Array<Int>
var ans = 0
var n = 0
var k = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nk = readLine().split(" ").map { it.toInt() }
    n = nk[0]
    k = nk[1]
    k -= 5

    if (k < 0) {
        println(0)
        return
    }
    words = Array(n) { readLine().apply { this.substring(4, this.length - 4) }.toBitmask() }
    dfs("antic".toBitmask(), 0, 0)
    println(ans)
}

fun String.toBitmask() = this.fold(0) { acc, c -> acc or (1 shl (c - 'a')) }

fun dfs(mask: Int, cur: Int, depth: Int) {
    if (depth == k) {
        ans = maxOf(ans, words.count { it and mask == it })
        return
    }

    for (i in cur..<26) {
        if (mask and (1 shl i) != 0) continue
        dfs(mask or (1 shl i), i + 1, depth + 1)
    }
}