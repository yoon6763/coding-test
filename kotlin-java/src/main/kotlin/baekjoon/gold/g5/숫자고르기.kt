package baekjoon.gold.g5

lateinit var arr: IntArray
lateinit var visited: BooleanArray
var n = 0
val list = ArrayList<Int>()

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    arr = IntArray(n + 1) { if (it == 0) 0 else readLine().toInt() }
    visited = BooleanArray(n + 1)

    for (i in 1..n) {
        visited.fill(false)
        visited[i] = true
        dfs(i, i)
    }

    println(list.size)
    println(list.sorted().joinToString("\n"))
}

fun dfs(idx: Int, target: Int) {
    if (visited[arr[idx]]) {
        if (arr[idx] == target) list.add(target)
        return
    }

    visited[arr[idx]] = true
    dfs(arr[idx], target)
}