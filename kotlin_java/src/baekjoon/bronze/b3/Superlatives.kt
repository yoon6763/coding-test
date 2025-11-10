package baekjoon.bronze.b3

fun main() {
    repeat(readln().toInt()) { index ->
        val (e, a) = readln().split(" ").map { it.toInt() }

        println("Data Set ${index + 1}:")

        if (e <= a) {
            println("no drought")
        } else {
            var factor = e.toDouble() s/ a
            if (factor <= 5) {
                println("drought")
            } else {
                var megaCount = 0
                while (factor > 5) {
                    megaCount++
                    factor /= 5
                }
                println("${"mega ".repeat(megaCount).trim()} drought")
            }
        }
        println()
    }
}
