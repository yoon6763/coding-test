package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    var add = 0

    while (true) {
        var stones = n + add
        var turn = 1

        while (stones >= turn) {
            stones -= turn
            turn++
        }

        if (turn % 2 == 0) {
            println(add)
            break
        }

        add++
    }
}
