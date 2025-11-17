package baekjoon.bronze.b2

fun main() {
    val line1 = readln().split(" ").map { it.toInt() }
    val line2 = readln().split(" ").map { it.toInt() }
    var a = 0
    var b = 0
    for (i in 0..<line1.size) {
        if (line1[i] == line2[i]) continue
        if (line1[i] > line2[i]) a++
        else b++
    }

    if (a == b) println("D")
    else if (a > b) println("A")
    else println("B")
}