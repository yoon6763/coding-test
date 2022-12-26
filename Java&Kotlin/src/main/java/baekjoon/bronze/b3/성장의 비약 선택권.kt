package baekjoon.bronze.b3

fun main() {
    val initial = readln().toInt()

    val levels = Array(4) { initial }
    for (i in 0 until 8) {
        levels[0]++
        if (levels[0] > 209) {
            break
        }
    }

    for (i in 0 until 4) {
        levels[1]++
        if (levels[1] > 219) {
            break
        }
    }

    for (i in 0 until 2) {
        levels[2]++
        if (levels[2] > 229) {
            break
        }
    }
    levels[3]++

    var idx = 3
    var temp = levels[3]
    for (i in 2 downTo 0) {
        if (temp < levels[i]) {
            idx = i
            temp = levels[i]
        }
    }
    println(idx + 1)
}