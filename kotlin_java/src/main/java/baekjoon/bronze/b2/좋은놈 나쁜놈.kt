package baekjoon.bronze.b2

fun main() {
    repeat(readln().toInt()) {
        val line = readln()
        var g = 0
        var b = 0

        line.forEach {
            when (it) {
                'G', 'g' -> g++
                'B', 'b' -> b++
            }
        }

        when {
            g == b -> println("$line is NEUTRAL")
            g > b -> println("$line is GOOD")
            else -> println("$line is A BADDY")
        }
    }
}
