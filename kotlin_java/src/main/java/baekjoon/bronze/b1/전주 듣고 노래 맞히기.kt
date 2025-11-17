package baekjoon.bronze.b1

fun main() {
    val (n, m) = readln().split(Regex("\\s+")).map { it.toInt() }
    val map = mutableMapOf<String, MutableList<String>>()

    repeat(n) {
        val parts = readln().split(Regex("\\s+"))
        val title = parts[1]
        val key = "${parts[2]} ${parts[3]} ${parts[4]}"
        map.getOrPut(key) { mutableListOf() }.add(title)
    }

    repeat(m) {
        val q = readln().split(Regex("\\s+"))
        val key = "${q[0]} ${q[1]} ${q[2]}"
        when {
            map[key] == null -> println("!")
            map[key]!!.size == 1 -> println(map[key]!![0])
            else -> println("?")
        }
    }
}
