package baekjoon.bronze

fun main() {
    val s = readln()

    var (k, y) = 0 to 0

    for (c in s) {
        when (c) {
            'K' -> if (k == 0) k++
            'O' -> {
                if (k == 1) k++
                if (y == 1) y++
            }

            'R' -> if (k == 2) k++
            'E' -> {
                if (k == 3) k++
                if (y == 4) y++
            }

            'A' -> if (k == 4) k++
            'Y' -> if (y == 0) y++
            'N' -> if (y == 2) y++
            'S' -> if (y == 3) y++
            'I' -> if (y == 5) y++
        }

        when {
            k == 5 -> {
                println("KOREA")
                return
            }

            y == 6 -> {
                println("YONSEI")
                return
            }
        }
    }
}