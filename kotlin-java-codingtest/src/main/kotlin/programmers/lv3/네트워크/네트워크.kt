package programmers.lv3.네트워크

lateinit var visited:Array<Boolean>

fun solution(n: Int, computers: Array<IntArray>): Int {
    visited = Array(n) {false}

    var cnt = 0

    for(i in 0 until n) {
        if(!visited[i]) {
            visited[i] = true
            cnt++
            dfs(n, i, computers)
        }
    }

    return cnt
}

fun dfs(n:Int, idx:Int, com:Array<IntArray>) {
    for(i in 0 until n) {
        if(!visited[i] && com[idx][i] == 1) {
            visited[i] = true
            dfs(n, i, com)
        }
    }
}