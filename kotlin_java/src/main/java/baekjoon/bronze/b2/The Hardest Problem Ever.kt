package baekjoon.bronze.b2

fun main() {
    while (true) {
        val start = readln()
        if (start == "ENDOFINPUT") break

        val line = readln()
        readln()

        val ans = buildString {
            line.forEach {
                append(if (it in 'A'..'Z') (((it - 'A' - 5 + 26) % 26) + 'A'.code).toChar() else it)
            }
        }

        println(ans)
    }
}