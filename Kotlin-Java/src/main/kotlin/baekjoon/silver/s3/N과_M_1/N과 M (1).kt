package baekjoon.silver.s3.N과_M_1

lateinit var visited: Array<Boolean> // 방문여부
lateinit var arr: Array<Int> // 배열

var n = 0
var m = 0

fun main() {
    val nm = readLine()!!.split(" ")
    m = nm[1].toInt()
    n = nm[0].toInt()

    arr = Array(n + 1) { i -> i }
    visited = Array(n + 1) { false }

    dfs(1, 0, "")
}

fun dfs(idx: Int, len: Int, str: String) {
    // 길이가 m인 수열을 만들었다면
    if (len == m) {
        println(str)
        return
    }

    for (i in 1..n) {
        // 해당 노드를 방문하지 않았다면
        if (!visited[i]) {
            visited[i] = true // 방문 여부를 체크

            if (len == 0)
                dfs(i, 1, arr[i].toString())
            else
                dfs(i, len + 1, "$str ${arr[i]}")

            visited[i] = false // 방문 여부를 다시 미방문 상태로 변경
        }
    }
}