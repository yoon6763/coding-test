package baekjoon.bronze.b3

fun main() {
    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ").map { it.toInt() }.sorted()

        print("Case ${it + 1}: ")
        if (a == b) {
            println(
                when (a) {
                    1 -> "Habb Yakk"
                    2 -> "Dobara"
                    3 -> "Dousa"
                    4 -> "Dorgy"
                    5 -> "Dabash"
                    6 -> "Dosh"
                    else -> ""
                }
            )
        } else {
            if (a == 5 && b == 6) println("Sheesh Beesh")
            else {
                val map = mapOf(1 to "Yakk", 2 to "Doh", 3 to "Seh", 4 to "Ghar", 5 to "Bang", 6 to "Sheesh")
                println("${map[b]} ${map[a]}")
            }
        }
    }
}