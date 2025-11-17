package baekjoon.silver.s2.`부등호`

lateinit var sign: Array<String>
lateinit var selected: IntArray
var n = 0
val visited = BooleanArray(10)
val answer = ArrayList<String>()

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    sign = readLine().split(" ").toTypedArray()
    selected = IntArray(n + 1) { -1 }

    backTracking(0)
    answer.sort()

    println(answer.last())
    println(answer.first())
}

fun backTracking(cur: Int) {
    if (cur == n + 1) {
        answer.add(selected.joinToString(""))
        return
    }

    val range =
        if (cur == 0) 0..9
        else if (sign[cur - 1] == "<") selected[cur - 1] + 1..9
        else selected[cur - 1] - 1 downTo 0

    for (i in range) {
        if (visited[i]) continue
        visited[i] = true
        selected[cur] = i
        backTracking(cur + 1)
        selected[cur] = -1
        visited[i] = false
    }
}