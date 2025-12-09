package baekjoon.bronze.b1

fun main() {
    var n = readln().toInt()
    var buffer = 0

    while (n > 0) {
        var time = 30
        while (time > 0 && n > 0) {
            val t = readln().toInt()
            n--
            if (time >= t / 2.0) buffer++
            time -= t
        }
    }

    println(buffer)
}
