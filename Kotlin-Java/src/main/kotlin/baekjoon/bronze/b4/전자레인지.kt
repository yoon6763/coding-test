package baekjoon.bronze.b4

fun main() {
    var n = readln().toInt()

    val time = arrayOf(300, 60, 10)
    val click = arrayOf(0, 0, 0)
    var ptr = 0

    while (ptr < 3) {
        if (n >= time[ptr]) {
            n -= time[ptr]
            click[ptr]++
        } else {
            ptr++
        }
    }

    if (n == 0) {
        println("${click[0]} ${click[1]} ${click[2]}")
    } else {
        println(-1)
    }
}