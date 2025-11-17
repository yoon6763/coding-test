package baekjoon.silver.s1.`본대 산책`

lateinit var graph: Array<MutableList<Int>>
var d = 0
var ans = 0

fun main() = with(System.`in`.bufferedReader()) {
    graph = Array(9) { mutableListOf<Int>() }
    d = readLine().toInt()

    // 1 - 2, 3
    graph[1].add(2)
    graph[1].add(3)

    // 2 - 1, 3, 4
    graph[2].add(1)
    graph[2].add(3)
    graph[2].add(4)

    // 3 - 1, 2, 4, 5
    graph[3].add(1)
    graph[3].add(2)
    graph[3].add(4)
    graph[3].add(5)

    // 4 - 2, 3, 5, 6
    graph[4].add(2)
    graph[4].add(3)
    graph[4].add(5)
    graph[4].add(6)

    // 5 - 3, 4, 6, 7
    graph[5].add(3)
    graph[5].add(4)
    graph[5].add(6)
    graph[5].add(7)

    // 6 - 4, 5, 8
    graph[6].add(4)
    graph[6].add(5)
    graph[6].add(8)

    // 7 - 5, 8
    graph[7].add(5)
    graph[7].add(8)

    // 8 - 6, 7
    graph[8].add(6)
    graph[8].add(7)

    val dp = Array(9) { IntArray(d + 1) }
    dp[1][0] = 1

    for (time in 1..d) {
        for (curNode in 1..8) {
            for (connectedNode in graph[curNode]) {
                dp[curNode][time] = (dp[curNode][time] + dp[connectedNode][time - 1]) % 1000000007
            }
        }
    }

    println(dp[1][d])
}