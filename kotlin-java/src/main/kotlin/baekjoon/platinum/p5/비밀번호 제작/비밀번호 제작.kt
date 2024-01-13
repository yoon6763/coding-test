package baekjoon.platinum.p5.`비밀번호 제작`

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val loginTry = readLine().split(" ").map(String::toInt)
    val visited = Array(n + 1) { -1 }

    val q = ArrayDeque<Int>()

    var length = 0
    var tempN = n

    while (tempN > 0) {
        tempN /= 2
        length++
    }

    loginTry.forEach {
        visited[it] = 0
        q.add(it)
    }

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()

        for (i in 0 until length) {
            val next = cur xor (1 shl i)
            if (next > n || visited[next] != -1) continue
            visited[next] = visited[cur] + 1
            q.add(next)
        }
    }

    println(visited.maxOrNull()!!)
}