package baekjoon.silver.s2.`소-난다!`

lateinit var cowWeight: List<Int>
val isPrime = BooleanArray(9001) { true }
val answerSet = HashSet<Int>()
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]
    cowWeight = readLine().split(" ").map { it.toInt() }

    isPrime[0] = false
    isPrime[1] = false
    for (i in 2..<isPrime.size) {
        if (!isPrime[i]) continue
        for (j in i * 2..<isPrime.size step i) {
            isPrime[j] = false
        }
    }

    dfs(0, 0, 0)
    println(if (answerSet.isNotEmpty()) answerSet.sorted().joinToString(" ") else -1)
}

fun dfs(index: Int, depth: Int, sum: Int) {
    if (depth == m) {
        if (isPrime[sum]) answerSet.add(sum)
        return
    }

    for (i in index..<n) {
        dfs(i + 1, depth + 1, sum + cowWeight[i])
        dfs(i + 1, depth, sum)
    }
}