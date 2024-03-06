package baekjoon.silver.s3.`로마 숫자 만들기`

val list = listOf(1, 5, 10, 50)
val isAble = BooleanArray(1001) { false }
var n = 0

fun main() {
    n = readln().toInt()
    dfs(0, 0, 0)
    println(isAble.count { it })
}

fun dfs(index: Int, depth: Int, sum: Int) {
    if (depth == n) {
        isAble[sum] = true
        return
    }

    for (i in index..<4) {
        dfs(i, depth + 1, sum + list[i])
    }
}