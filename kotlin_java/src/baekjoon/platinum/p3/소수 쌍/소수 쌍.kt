package baekjoon.platinum.p3.`소수 쌍`

lateinit var isPrimes: BooleanArray
lateinit var graph: Array<MutableList<Int>>
lateinit var visited: BooleanArray
lateinit var matched: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }
    isPrimes = BooleanArray(2000) { true }
    visited = BooleanArray(n)
    matched = IntArray(n)
    graph = Array(n) { mutableListOf<Int>() }

    makePrimesArray()

    for (i in 0..<n) {
        for (j in i + 1..<n) {
            if (isPrimes[arr[i] + arr[j]]) {
                graph[i].add(j)
                graph[j].add(i)
            }
        }
    }

    val connected = ArrayList<Int>()

    for (i in 0..<graph[0].size) {
        matched.fill(-1)
        var ans = 1

        matched[graph[0][i]] = 0

        for (j in 1..<n) {
            visited.fill(false)
            if (dfs(j)) ans++
        }

        if (ans == n) {
            connected.add(arr[graph[0][i]])
        }
    }

    if (connected.isEmpty()) {
        println(-1)
        return
    }

    println(connected.sorted().joinToString(" "))
}

fun makePrimesArray() {
    for (i in 2..<2000) {
        if (isPrimes[i]) {
            for (j in i + i..<2000 step i) {
                isPrimes[j] = false
            }
        }
    }
}

fun dfs(cur: Int): Boolean {
    if (visited[cur] || cur == 0) return false
    visited[cur] = true

    for (next in graph[cur]) {
        if (matched[next] == -1 || dfs(matched[next])) {
            matched[next] = cur
            return true
        }
    }
    return false
}