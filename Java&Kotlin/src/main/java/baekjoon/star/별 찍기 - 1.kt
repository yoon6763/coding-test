package baekjoon.star

fun main() {
    val layer: Int = readLine()!!.toInt()
    for (i in 0 until layer) {
        for (j in 0..i) print("*")
        println("")
    }
}