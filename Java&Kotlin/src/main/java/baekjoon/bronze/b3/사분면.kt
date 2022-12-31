package baekjoon.bronze.b3

fun main() {
    val sector = Array(5) { 0 }
    repeat(readln().toInt()) {
        val (x, y) = readln().split(" ").map { it.toInt() }

        if (x > 0 && y > 0) {
            sector[0]++
        } else if (x < 0 && y > 0) {
            sector[1]++
        } else if (x < 0 && y < 0) {
            sector[2]++
        } else if (x > 0 && y < 0) {
            sector[3]++
        } else {
            sector[4]++
        }
    }

    repeat(4) {
        println("Q${it + 1}: ${sector[it]}")
    }
    println("AXIS: ${sector[4]}")
}