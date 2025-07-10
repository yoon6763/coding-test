package baekjoon.silver.s3

fun main() {
    val n = readln().toInt()
    val arr = IntArray(n)

    fun dfs(depth: Int, pre: Int, sum: Int) {
        if (sum == n) {
            println(arr.slice(0..<depth).joinToString(" "))
            return
        }

        for (i in pre downTo 1) {
            if (sum + i > n) continue
            arr[depth] = i
            dfs(depth + 1, i, sum + i)
        }
    }

    dfs(0, n, 0)
}