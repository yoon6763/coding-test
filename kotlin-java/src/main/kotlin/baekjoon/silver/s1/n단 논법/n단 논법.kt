package baekjoon.silver.s1.`n단 논법`

lateinit var graph: HashMap<String, ArrayList<String>>
val visited = HashSet<String>()
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    graph = HashMap()

    repeat(n) {
        val (a, b) = readLine().split(" is ")
        if (a !in graph) {
            graph[a] = ArrayList()
        }

        graph[a]!!.add(b)
        if (b !in graph) {
            graph[b] = ArrayList()
        }
    }

    repeat(readLine().toInt()) {
        val (a, b) = readLine().split(" is ")
        visited.clear()
        println(if (dfs(a, b)) "T" else "F")
    }
}

fun dfs(cur: String, target: String): Boolean {
    if (cur == target) {
        return true
    }

    visited.add(cur)
    graph[cur]!!.forEach {
        if (it !in visited && dfs(it, target)) {
            return true
        }
    }

    return false
}