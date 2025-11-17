package baekjoon.gold.g5

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val friends = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        friends[a].add(b)
        friends[b].add(a)
    }

    println(
        (1..n).flatMap { i ->
            friends[i].flatMap { j ->
                friends[j].mapNotNull { k ->
                    if (i in friends[k]) friends[i].size + friends[j].size + friends[k].size - 6 else null
                }
            }
        }.minOrNull() ?: -1
    )
}
