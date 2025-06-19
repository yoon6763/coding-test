package baekjoon.silver.s3.눈덩이굴리기

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = "0 ${readln()} 0".split(" ").map { it.toInt() }.toIntArray()

    fun dfs(cur: Int, depth: Int, index: Int): Int {
        if (depth > m) return 0
        if (index >= n) return cur

        return listOf(
            cur,
            dfs(cur + arr[index + 1], depth + 1, index + 1),
            dfs((cur / 2) + arr[index + 2], depth + 1, index + 2)
        ).max()
    }

    println(dfs(1, 0, 0))
}

/*
10 5
1 3 4 5 6 7 8 10 12 14
 */