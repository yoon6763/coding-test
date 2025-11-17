package baekjoon.bronze.b1

fun main() {
    val arr = Array(3) { readln().split(" ").map { it.toInt() } }

    val map = Array(3) { x -> Array(3) { y -> arr[x][y] } }

    for (i in 0 until 3) {
        for (j in 0 until 3) {
            if (arr[i][j] == 0) {
                var cnt = 0
                for (x in i - 1..i + 1) {
                    for (y in j - 1..j + 1) {
                        if (x in 0 until 3 && y in 0 until 3 && arr[x][y] == 9) cnt++
                    }
                }
                map[i][j] = cnt
            }
        }
    }

    map.forEach {
        it.forEach {
            print("$it ")
        }
        println()
    }
}