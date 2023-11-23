package baekjoon.silver.s1.쿼드트리

import java.io.BufferedReader
import java.io.InputStreamReader

val result = StringBuilder()
lateinit var map: Array<Array<Int>>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    map = Array(n) { Array(n) { 0 } }

    repeat(n) { x ->
        val line = br.readLine()
        repeat(n) { y ->
            map[x][y] = line[y] - '0'
        }
    }

    find(n, 0, 0)
    println(result)
}

fun find(n: Int, x: Int, y: Int) {
    val firstVal = map[x][y]
    for (i in x until  x + n) {
        for (j in y until  y + n) {
            if (map[i][j] != firstVal) {

                result.append("(")
                find(n / 2, x, y)
                find(n / 2, x, y + n / 2)
                find(n / 2, x + n / 2, y)
                find(n / 2, x + n / 2, y + n / 2)
                result.append(")")

                return
            }
        }
    }
    result.append(map[x][y])
}

/*
((110(0101))(0010)1(0001))

8
11110000
11110000
00011100
00011100
11110000
11110000
11110011
11110011
 */