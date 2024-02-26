package baekjoon.silver.s3.`1072 게임`

import kotlin.math.floor

fun main() {
    val line = readLine()!!.split(" ")
    var num = line[0].toDouble()
    var win = line[1].toDouble()
    val initRatio: Double = win * 100 / num

    if (initRatio >= 99) {
        println(-1)
    } else {
        var min = 0
        var max = Int.MAX_VALUE
        var game = 0

        while (min <= max) {
            var mid = (min + max) / 2
            val plusRadio = (win + mid) * 100 / (num + mid)

            if (floor(initRatio) < floor(plusRadio)) {
                max = mid - 1
                game = mid
            } else {
                min = mid + 1
            }
        }
        println(game)
    }
}