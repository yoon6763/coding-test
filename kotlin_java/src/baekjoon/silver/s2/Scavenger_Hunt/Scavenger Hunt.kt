package baekjoon.silver.s2.Scavenger_Hunt

fun main() = repeat(readln().toInt()) {
    val map = HashMap<String, String>()

    repeat(readln().toInt() - 1) {
        val (a, b) = readln().split(" ")
        map[a] = b
    }

    println("Scenario #${it + 1}:")
    dfs((map.keys - map.values.toSet()).first(), map)
    println()
}

fun dfs(cur: String, map: HashMap<String, String>) {
    println(cur)
    dfs(map[cur] ?: return, map)
}