package baekjoon.silver.s1

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n) { readln().toCharArray() }
    val visited = Array(n) { BooleanArray(m) }

    val delta = arrayOf(
        // figure1
        arrayOf(arrayOf(0 to 0, 0 to 1, 1 to 0, 1 to 1)),
        // figure2
        arrayOf(arrayOf(0 to 0, 0 to 1, 0 to 2, 0 to 3), arrayOf(0 to 0, 1 to 0, 2 to 0, 3 to 0)),
        // figure3
        arrayOf(
            arrayOf(0 to 0, 0 to 1, -1 to 1, -1 to 2),
            arrayOf(0 to 0, 1 to 0, 1 to 1, 2 to 1),
        ),
        // figure4
        arrayOf(
            arrayOf(0 to 0, 0 to 1, 1 to 1, 1 to 2),
            arrayOf(0 to 0, 1 to 0, 1 to -1, 2 to -1),
        ),
        // figure5 ㅗㅜㅏㅓ
        arrayOf(
            arrayOf(0 to 0, 0 to 1, 0 to 2, 1 to 1),
            arrayOf(0 to 0, 0 to 1, 0 to 2, -1 to 1),
            arrayOf(0 to 0, 1 to 0, 2 to 0, 1 to 1),
            arrayOf(0 to 0, 1 to 0, 2 to 0, 1 to -1),
        ),
    )

    val count = IntArray(5)

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (graph[i][j] == '.' || visited[i][j]) continue
            for (k in delta.indices) {
                loop@ for (d in delta[k]) {
                    val positions = d.map { (dx, dy) -> i + dx to j + dy }
                    if (positions.any { (x, y) -> x !in 0 until n || y !in 0 until m || graph[x][y] != graph[i][j] || visited[x][y] }) continue@loop
                    positions.forEach { (x, y) -> visited[x][y] = true }
                    count[k]++
                    break
                }
            }
        }
    }

    println(count.joinToString("\n"))
}