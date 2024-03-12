package baekjoon.platinum.p5.`다이아몬드 광산`

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val leftDp = Array(n) { IntArray(m) }
    val rightDp = Array(n) { IntArray(m) }

    val map = Array(n) { readLine().toCharArray() }
    for (i in 0..<n) {
        for (j in 0..<m) {
            if (map[i][j] == '0') {
                leftDp[i][j] = 0
                rightDp[i][j] = 0
            } else {
                leftDp[i][j] = 1
                rightDp[i][j] = 1
            }
        }
    }

    for (i in n - 2 downTo 0) {
        for (j in 0..<m) {
            if (leftDp[i][j] == 1 && j != 0) {
                leftDp[i][j] += leftDp[i + 1][j - 1]
            }
            if (rightDp[i][j] == 1 && j != m - 1) {
                rightDp[i][j] += rightDp[i + 1][j + 1]
            }
        }
    }

    var answer = 0

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (leftDp[i][j] != 0 && rightDp[i][j] != 0) {
                answer = maxOf(answer, 1)
                if (leftDp[i][j] != 1 && rightDp[i][j] != 1) {
                    var temp = minOf(leftDp[i][j], rightDp[i][j])
                    while (temp > 1) {
                        if (rightDp[i + temp - 1][j - temp + 1] >= temp && leftDp[i + temp - 1][j + temp - 1] >= temp) {
                            answer = maxOf(answer, temp)
                        }
                        temp--
                    }
                }
            }
        }
    }

    println(answer)
}