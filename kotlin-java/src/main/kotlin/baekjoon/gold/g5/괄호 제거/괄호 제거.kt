package baekjoon.gold.g5.`괄호 제거`

lateinit var visited: BooleanArray
val bracketPoints = mutableListOf<Pair<Int, Int>>()
val answerSet = mutableSetOf<String>()
var str = ""

fun main() = with(System.`in`.bufferedReader()) {
    str = readLine()
    val stack = ArrayDeque<Int>()

    for (cur in str.indices) {
        if (str[cur] == '(') {
            stack.add(cur)
        } else if (str[cur] == ')') {
            bracketPoints.add(stack.removeLast() to cur)
        }
    }

    visited = BooleanArray(str.length)
    dfs(0)
    answerSet.remove(str)
    answerSet.sorted().forEach { println(it) }
}

fun dfs(cur: Int) {
    if (cur == bracketPoints.size) {
        val sb = StringBuilder()
        for (i in str.indices) {
            if (!visited[i]) sb.append(str[i])
        }
        answerSet.add(sb.toString())
        return
    }

    dfs(cur + 1)
    visited[bracketPoints[cur].first] = true
    visited[bracketPoints[cur].second] = true
    dfs(cur + 1)
    visited[bracketPoints[cur].first] = false
    visited[bracketPoints[cur].second] = false
}
