package programmers.lv3

fun main() {
    var array = Array(3) { intArrayOf(0, 0, 0) }
    array[0] = intArrayOf(1, 1, 0)
    array[1] = intArrayOf(1, 1, 0)
    array[2] = intArrayOf(0, 0, 1)

    println(solution(3, array))
}

var group = 0
lateinit var visited: Array<Boolean>

fun solution(n: Int, computer: Array<IntArray>): Int {
    visited = Array(n) { false }

    for (i in 0 until n) if(!visited[i] && dfs(n, i, computer)) group++

    return group
}

fun dfs(n:Int, idx: Int, computer: Array<IntArray>):Boolean {
    visited[idx] = true

    for(i in 0 until n) {
        if(visited[i] || computer[idx][i] == 0) continue

        visited[i] = true
        dfs(n, i, computer)
    }
    return true
}