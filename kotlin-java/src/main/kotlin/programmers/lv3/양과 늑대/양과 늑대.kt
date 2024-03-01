package programmers.lv3.`양과 늑대`

lateinit var graph: Array<MutableList<Int>>
var ans = 0

// 0은 양, 1은 늑대
fun solution(info: IntArray, edges: Array<IntArray>): Int {
    val n = info.size
    graph = Array(n) { mutableListOf<Int>() }

    edges.forEach { (s, e) ->
        graph[s].add(e)
        graph[e].add(s)
    }

    dfs(0, 0, 0, info, BooleanArray(n))
    return ans
}

fun dfs(now: Int, sheep: Int, wolf: Int, info: IntArray, visited: BooleanArray) {
    var sheep = sheep
    var wolf = wolf
    visited[now] = true

    if (info[now] == 0) {
        sheep++
        ans = maxOf(ans, sheep)
    } else wolf++

    if (sheep <= wolf) return


    graph.forEachIndexed { index, ints ->
        if (visited[index]) {
            ints.forEach { next ->
                if (!visited[next]) {
                    dfs(next, sheep, wolf, info, visited.clone())
                }
            }
        }
    }
}

