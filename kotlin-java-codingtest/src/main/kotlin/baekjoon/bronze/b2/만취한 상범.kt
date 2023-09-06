package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val n = readLine().toInt()

        val visited = Array(n + 1) { false }
        for (i in 1..n) {
            for (j in i..n step i) {
                visited[j] = !visited[j]
            }
        }

        sb.append(visited.count { it }).append("\n")
    }

    print(sb)
}