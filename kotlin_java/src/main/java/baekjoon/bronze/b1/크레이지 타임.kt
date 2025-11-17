package baekjoon.bronze.b1

fun main() {
    var time = 1
    var dir = 1

    repeat(readln().toInt()) {
        val line = readln().split(" ")
        val (s, x) = line[0] to line[1].toInt()

        val isSync = (time == x)
        val over = s == "HOURGLASS" && isSync

        println("$time ${if (!over && isSync) "YES" else "NO"}")

        if (!over && s == "HOURGLASS") dir = -dir

        time = (time + dir - 1 + 12) % 12 + 1
    }
}

