package baekjoon.silver.s5

fun main() {
    val line = readln()
    var result = ""

    for (i in 1 until line.length - 1) {
        for (j in i + 1 until line.length) {
            val w1 = line.substring(0, i).reversed()
            val w2 = line.substring(i, j).reversed()
            val w3 = line.substring(j, line.length).reversed()
            val nLine = w1 + w2 + w3
            if (nLine < result || (i == 1 && j == i + 1)) result = nLine
        }
    }

    println(result)
}