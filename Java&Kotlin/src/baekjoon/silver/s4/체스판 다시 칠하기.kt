package baekjoon.silver.s4

fun main() {
    val nm = readLine()!!.split(" ")
    val n = nm[0].toInt()
    val m = nm[1].toInt()

    val map = Array(n) { Array<Char>(m) { ' ' } }

    for (i in 0 until n) {
        val line = readLine()!!
        for (j in 0 until m) {
            map[i][j] = line[j]
        }
    }

    var result = Int.MAX_VALUE


    // 0, 0 이 B
    for (a in 0 until n - 7) {
        for (b in 0 until m - 7) {

            var result1 = 0
            var result2 = 0

            for (i in 0 until 8) {
                for (j in 0 until 8) {
                    val target = if ((i + a) % 2 == 0) {
                        if ((j + b) % 2 == 0) {
                            'B'
                        } else {
                            'W'
                        }
                    } else {
                        if ((j + b) % 2 == 0) {
                            'W'
                        } else {
                            'B'
                        }
                    }

                    if (map[i + a][j + b] != target) {
                        result1++
                    }
                }
            }


            // 0, 0 이 W
            for (i in 0 until 8) {
                for (j in 0 until 8) {
                    var target = ' '
                    target = if ((i + a) % 2 == 0) {
                        if ((j + b) % 2 == 0) {
                            'W'
                        } else {
                            'B'
                        }
                    } else {
                        if ((j + b) % 2 == 0) {
                            'B'
                        } else {
                            'W'
                        }
                    }

                    if (map[i + a][j + b] != target) {
                        result2++
                    }
                }
            }

            if (result > result1) {
                result = result1
            }
            if (result > result2) {
                result = result2
            }
        }
    }

    print("$result")
}


/*
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBW
 */