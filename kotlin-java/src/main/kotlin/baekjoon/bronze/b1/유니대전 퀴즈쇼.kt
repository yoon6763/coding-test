package baekjoon.bronze.b1

fun main() = with(System.`in`.bufferedReader()) {
    val line = readLine().split(" ")
    val n = line[0].toInt()
    val answerUser = line[1]

    val chatList = Array(n) { readLine().split(" ") }
    val keyword = chatList.find { it[0] == answerUser }!![1]

    var answer = 0

    for (i in 0 until n) {
        if (chatList[i][0] == answerUser) {
            break
        }
        if (chatList[i][1] == keyword) {
            answer++
        }
    }

    println(answer)
}