package baekjoon.platinum.p4.불_끄기

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val originMap = Array(10) { BooleanArray(10) }

    repeat(10) {
        val line = readLine()
        for (i in 0 until 10) {
            originMap[it][i] = line[i] == 'O'
        }
    }

    var answer = Int.MAX_VALUE

    repeat(1024) { i ->
        val copiedMap = Array(10) { i -> BooleanArray(10) { j -> originMap[i][j] } }
        var count = 0

        for (j in 0 until 10) {
            if (((1 shl j) and i) == 0) {
                switchChange(copiedMap, 0, j)
                count++
            }
        }

        for (j in 1 until 10) {
            for (k in 0 until 10) {
                if (copiedMap[j - 1][k]) {
                    switchChange(copiedMap, j, k)
                    count++
                }
            }
        }

        if (copiedMap.all { it.all { !it } }) {
            answer = answer.coerceAtMost(count)
        }
    }

    println(if (answer == Int.MAX_VALUE) -1 else answer)
}

fun switchChange(copyMap: Array<BooleanArray>, i: Int, j: Int) {
    copyMap[i][j] = !copyMap[i][j]

    for (k in 0 until 4) {
        val nx = i + dx[k]
        val ny = j + dy[k]

        if (nx !in 0 until 10 || ny !in 0 until 10) continue
        copyMap[nx][ny] = !copyMap[nx][ny]
    }
}
