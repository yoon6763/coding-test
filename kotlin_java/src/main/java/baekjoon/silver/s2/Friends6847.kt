package baekjoon.silver.s2

fun main() {
    val friends = HashMap<Int, Int>()

    repeat(readln().toInt()) {
        val (from, to) = readln().split(" ").map { it.toInt() }
        friends[from] = to
    }

    val visited = HashSet<Int>()

    fun isCycle(cur: Int, start: Int): Boolean {
        val next = friends[cur]!!
        if (next == start) return true
        if (next in visited) return false
        visited += next
        return isCycle(next, start)
    }

    fun distance(cur: Int, target: Int, depth: Int): Int {
        val next = friends[cur]!!
        if (next == target) return depth
        return distance(next, target, depth + 1)
    }

    while (true) {
        val (a, b) = readln().split(" ").map { it.toInt() }.apply { if (all { it == 0 }) return }
        visited.clear()
        println(if (isCycle(a, a) && b in visited) "Yes ${distance(a, b, 0)}" else "No")
    }
}