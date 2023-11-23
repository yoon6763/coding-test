package baekjoon.silver.s5

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val map = Array(n) { readLine().toCharArray() }
    val resultMap = Array(n) { CharArray(n) { '*' } }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (map[i][j] == '.') {
                var cnt = 0
                for (x in i - 1..i + 1) {
                    for (y in j - 1..j + 1) {
                        if (x in 0 until n && y in 0 until n && map[x][y] != '.') cnt += map[x][y] - '0'
                    }
                }
                resultMap[i][j] = if (cnt > 9) 'M' else cnt.toString()[0]
            }
        }
    }

    resultMap.forEach {
        println(it.joinToString(""))
    }
}