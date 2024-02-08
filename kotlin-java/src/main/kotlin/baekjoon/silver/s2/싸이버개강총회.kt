package baekjoon.silver.s2

fun main() = with(System.`in`.bufferedReader()) {
    val (s, e, q) = readLine().split(" ").map { it.split(":").map { it.toInt() } }

    val start = s[0] * 60 + s[1]
    val end = e[0] * 60 + e[1]
    val streamingEnd = q[0] * 60 + q[1]

    val checkedStudentsBeforeStart = HashSet<String>()
    val checkedStudentsAfterEnd = HashSet<String>()

    while (true) {
        val input = readLine() ?: break
        val (time, name) = input.split(" ")
        val (h, m) = time.split(":").map { it.toInt() }
        val currentTime = h * 60 + m

        if (currentTime <= start) {
            checkedStudentsBeforeStart.add(name)
        } else if (currentTime in end..streamingEnd && name in checkedStudentsBeforeStart) {
            checkedStudentsAfterEnd.add(name)
        }
    }

    println(checkedStudentsAfterEnd.size)
}