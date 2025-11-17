package baekjoon.bronze.b3

fun main() {
    val N = readln().toInt()
    val s = readln()
    val K = readln().toInt()

    when (s) {
        "annyong" -> {
            if (K % 2 == 1) {
                println(K)
            } else {
                println(if (K + 1 <= N) K + 1 else K - 1)
            }
        }

        "induck" -> {
            if (K % 2 == 0) {
                println(K)
            } else {
                println(if (K + 1 <= N) K + 1 else K - 1)
            }
        }
    }
}
