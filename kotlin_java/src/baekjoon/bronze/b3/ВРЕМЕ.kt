package baekjoon.bronze.b3

fun main() {
    val durations = List(3) {
        val (sh, sm, eh, em) = readln().trim().split(" ").map { it.toInt() }
        val start = sh * 60 + sm
        var end = eh * 60 + em
        if (end < start) end += 24 * 60
        end - start
    }

    val formatTime: (Int) -> String = { "%d:%02d".format(it / 60, it % 60) }
    println(formatTime(durations.min()))
    println(formatTime(durations.max()))
}