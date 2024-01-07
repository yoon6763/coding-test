package baekjoon.bronze.b4

fun main() {
    var d = 0

    repeat(10) {
        when (readln().toInt()) {
            1 -> d += 1
            2 -> d += 2
            3 -> d -= 1
        }

        if (d < 0) {
            d += 4
        } else if (d > 3) {
            d -= 4
        }
    }

    println("NESW"[d])
}
