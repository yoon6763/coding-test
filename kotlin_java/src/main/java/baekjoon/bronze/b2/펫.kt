package baekjoon.bronze.b2

fun main() {
    var idx = 0
    while (true) {
        idx++
        var (o, w) = readln().split(" ").map { it.toInt() }
        if (o == 0 && w == 0) break
        var isDie = false

        while (true) {
            val input = readln().split(" ")
            when (input[0]) {
                "#" -> break
                "E" -> w -= input[1].toInt()
                "F" -> w += input[1].toInt()
            }
            if (w <= 0) isDie = true
        }

        if (isDie) println("$idx RIP")
        else if (w > (o / 2) && w < (o * 2)) println("$idx :-)")
        else println("$idx :-(")
    }
}