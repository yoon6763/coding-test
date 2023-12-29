package baekjoon.silver.s4

fun main() {
    val origin = readln()
    var maxScore = 0.0
    var maxWord = ""

    nextWord@ for (i in 0..<readln().toInt()) {
        val line = readln().split(" ")

        val dict = line[0].toMutableList()
        var score = line[1].toDouble()

        for (c in origin) {
            if (c in dict) dict.remove(c) else continue@nextWord
        }

        score /= dict.size

        if (score > maxScore) {
            maxScore = score
            maxWord = line[0]
        }
    }

    println(if (maxWord == "") "No Jam" else maxWord)
}