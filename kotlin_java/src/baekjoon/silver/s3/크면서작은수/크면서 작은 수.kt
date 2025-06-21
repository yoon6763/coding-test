package baekjoon.silver.s3.크면서작은수

fun main() {
    val arr = readln().toCharArray()
    println(solve(arr, 0, BooleanArray(arr.size), "").takeIf { it != Int.MAX_VALUE } ?: 0)
}

fun solve(arr: CharArray, depth: Int, visited: BooleanArray, cur: String): Int {
    if (depth == arr.size) return if (cur.toInt() <= arr.joinToString("").toInt()) Int.MAX_VALUE else cur.toInt()

    var ans = Int.MAX_VALUE

    for (i in arr.indices) {
        if (visited[i]) continue
        visited[i] = true
        ans = minOf(solve(arr, depth + 1, visited, cur + arr[i]), ans)
        visited[i] = false
    }

    return ans
}