package baekjoon.gold.g4

fun main() = with(System.`in`.bufferedReader()) {

    val damage = arrayOf(
        arrayOf(9, 3, 1),
        arrayOf(9, 1, 3),
        arrayOf(3, 9, 1),
        arrayOf(3, 1, 9),
        arrayOf(1, 3, 9),
        arrayOf(1, 9, 3)
    )

    val n = readLine().toInt()
    val scvInput = readLine().split(" ").map { it.toInt() }.sortedDescending().toMutableList()

    while (scvInput.size < 3) scvInput.add(0)

    val scv = scvInput.toIntArray()
    val visited = Array(61) { Array(61) { Array(61) { -1 } } }

    val q = ArrayDeque<IntArray>()
    q.add(scv)
    visited[scv[0]][scv[1]][scv[2]] = 0

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()
        val copied = Array(6) { i -> IntArray(3) { j -> maxOf(0, cur[j] - damage[i][j]) } }

        copied.forEach { arr ->
            if (visited[arr[0]][arr[1]][arr[2]] != -1) return@forEach

            q.add(arr)
            visited[arr[0]][arr[1]][arr[2]] = visited[cur[0]][cur[1]][cur[2]] + 1

            if (arr.all { it == 0 }) {
                println(visited[0][0][0])
                return@with
            }
        }
    }
}