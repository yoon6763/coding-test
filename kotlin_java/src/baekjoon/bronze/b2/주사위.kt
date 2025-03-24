package baekjoon.bronze.b2

fun main() {
    val count = Array(20 * 20 * 40 + 1) { 0 }

    val (s1, s2, s3) = readln().split(" ").map { it.toInt() }
    for (i in 1..s1) {
        for (j in 1..s2) {
            for (k in 1..s3) {
                count[i + j + k]++
            }
        }
    }

    println(count.indexOf(count.maxOrNull()))
}