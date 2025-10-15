package baekjoon.bronze.b1

fun main() {
    val (k, n) = readln().split(" ").map { it.toInt() }
    val arr = Array(k) { readln().split(" ").map { it.toInt() } }
    var answer = 0

    for (i in 1..n) {
        x@ for (j in 1..n) {
            if (i == j) continue
            for (l in 0 until k) {
                if (arr[l].indexOf(i) > arr[l].indexOf(j)) continue@x
            }
            answer++
        }
    }

    println(answer)
}
