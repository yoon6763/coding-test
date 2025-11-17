package baekjoon.bronze.b3

fun main() {
    repeat(readln().toInt()) {
        var (p1, p2) = 0 to 0
        repeat(readln().toInt()) {
            val (rps1, rps2) = readln().split(" ")
            when (rps1) {
                "R" -> {
                    when (rps2) {
                        "P" -> p2++
                        "S" -> p1++
                    }
                }

                "P" -> {
                    when (rps2) {
                        "R" -> p1++
                        "S" -> p2++
                    }
                }

                "S" -> {
                    when (rps2) {
                        "R" -> p2++
                        "P" -> p1++
                    }
                }
            }
        }

        when {
            p1 > p2 -> println("Player 1")
            p1 < p2 -> println("Player 2")
            else -> println("TIE")
        }
    }
}