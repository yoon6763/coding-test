package baekjoon.silver.s1.마니또

fun main() = with(System.`in`.bufferedReader()) {
    generateSequence {
        readLine().toInt().takeIf { it != 0 }
    }.forEachIndexed { index, n ->
        val map = generateSequence { readLine().split(" ").takeIf { it.size == 2 } }
            .take(n)
            .associate { it[0] to it[1] }

        val visited = mutableSetOf<String>()

        val answer = map.keys.fold(0) { acc, key ->
            if (key in visited) acc
            else {
                visited.add(key)
                acc + dfs(key, key, map, visited)
            }
        }

        println("${index + 1} $answer")
    }
}

fun dfs(cur: String, start: String, map: Map<String, String>, visited: MutableSet<String>): Int =
    when {
        cur !in map -> 0
        map[cur] == start -> 1
        map[cur] !in visited -> {
            visited.add(map[cur]!!)
            dfs(map[cur]!!, start, map, visited)
        }

        else -> 0
    }