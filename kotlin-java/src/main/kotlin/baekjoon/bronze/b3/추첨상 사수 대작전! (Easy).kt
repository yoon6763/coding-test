package baekjoon.bronze.b3

fun main() {
    val (m, seed, x1, x2) = readln().split(" ").map { it.toInt() }

    for (i in 0..<100) {
        for (j in 0..<100) {
            if (x1 == (i * seed + j) % m && x2 == (i * ((i * seed + j) % m) + j) % m) {
                println("$i $j")
                return
            }
        }
    }
}
