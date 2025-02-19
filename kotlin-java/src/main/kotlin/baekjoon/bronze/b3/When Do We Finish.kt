package baekjoon.bronze.b3

fun main() = generateSequence { readln().takeIf { it != "00:00 00:00" } }
    .map { it.split(" ").map { time -> time.split(":").map(String::toInt) } }
    .map { (start, elapsed) ->
        val (startHour, startMin) = start
        val (elapsedHour, elapsedMin) = elapsed

        val totalMin = startMin + elapsedMin
        val totalHour = startHour + elapsedHour + totalMin / 60
        val extraDays = totalHour / 24

        "%02d:%02d%s".format(totalHour % 24, totalMin % 60, if (extraDays > 0) " +$extraDays" else "")
    }.forEach(::println)