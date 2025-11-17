package baekjoon.bronze.b1

fun main() = repeat(readln().toInt()) {
    val game = readln()
    val evenChars = game.filterIndexed { index, _ -> index % 2 == 0 }
    val oddChars = game.filterIndexed { index, _ -> index % 2 == 1 }
    println(if (game.length % 2 == 0) "$evenChars\n$oddChars" else "${evenChars + oddChars}\n${oddChars + evenChars}")
}
