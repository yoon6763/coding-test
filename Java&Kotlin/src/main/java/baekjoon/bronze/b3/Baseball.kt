package baekjoon.bronze.b3

fun main() {
    val T = readLine()!!.toInt()
    repeat(T) {
        var yScore = 0
        var kScore = 0

        repeat(9) {
            // y, k
            val score = readLine()!!.split(" ").map { it.toInt() }
            yScore += score[0]
            kScore += score[1]
        }
        if(yScore>kScore) println("Yonsei")
        else if(yScore < kScore) println("Korea")
        else println("Draw")
    }
}