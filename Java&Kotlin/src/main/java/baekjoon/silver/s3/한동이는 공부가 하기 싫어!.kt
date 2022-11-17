package baekjoon.silver.s3

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val arr = Array(n) { 0 }
    val depth = Array(n) { -1 }

    repeat(n) {
        arr[it] = br.readLine().toInt() - 1
    }

    for (i in 0 until n) {
        var idx = i
        var nowDepth = 0

        val visited = Array(n) { false }
        visited[idx] = true

        while (true) {
            idx = arr[idx]
            if (visited[idx]) break

            visited[idx] = true
            nowDepth++
        }
        depth[i] = nowDepth
    }

    println(depth.indexOfFirst { it == depth.maxOrNull()!! } + 1)
}
