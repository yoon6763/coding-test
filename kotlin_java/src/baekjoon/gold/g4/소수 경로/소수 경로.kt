package baekjoon.gold.g4.`소수 경로`

lateinit var isPrime: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    isPrime = BooleanArray(10000) { true }

    for (i in 2..9999) {
        if (isPrime[i]) {
            for (j in i + i..9999 step i) {
                isPrime[j] = false
            }
        }
    }

    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val (start, end) = readLine().split(" ").map { it.toInt() }
        val shortestPath = findShortestPath(start, end)
        sb.appendLine(if (shortestPath == -1) "Impossible" else shortestPath)
    }

    print(sb)
}

fun findShortestPath(start: Int, end: Int): Int {
    if (start == end) return 0

    val visited = IntArray(10000) { -1 }
    visited[start] = 0

    val queue = ArrayDeque<Int>()
    queue.add(start)

    while (queue.isNotEmpty()) {
        val cur = queue.removeFirst()

        for (i in 0..<4) {
            for (j in 0..9) {
                val next = changeNumber(cur, i, j)

                if (next < 1000 || !isPrime[next] || visited[next] != -1) continue
                queue.add(next)
                visited[next] = visited[cur] + 1

                if (next == end) {
                    return visited[next]
                }
            }
        }
    }

    return -1
}

fun changeNumber(originNumber: Int, index: Int, targetNumber: Int): Int {
    val parsedNumber = originNumber.toString().toCharArray()
    parsedNumber[index] = targetNumber.digitToChar()
    return parsedNumber.joinToString("").toInt()
}
