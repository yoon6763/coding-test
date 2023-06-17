package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val goal = BooleanArray(3)
    goal[0] = true

    repeat(readLine().toInt()) {
        val (a, b) = readLine().split(" ").map { it.toInt() - 1 }
        val temp = goal[a]
        goal[a] = goal[b]
        goal[b] = temp
    }

    println(goal.indexOf(true) + 1)
}