package baekjoon.bronze.b1


fun main() {
    val (c, r) = readln().split(" ").map { it.toInt() }
    val arr = List(r) { readln().split(" ").map { it.toInt() } }

    val rotated = Array(c) { IntArray(r) }

    // 반시계 방향으로 90도 회전
    for (i in 0 until r) {
        for (j in 0 until c) {
            rotated[j][r - i - 1] = arr[i][j]
        }
    }

    for (i in 0..<c) {
        val line = readln().split(" ").map { it.toInt() }
        for (j in 0..<r) {
            if (rotated[i][j] != line[j]) {
                println(
                    ("|>___/|     /}\n" +
                            "| O O |    / }\n" +
                            "( =0= )\"\"\"\"  \\\n" +
                            "| ^  ____    |\n" +
                            "|_|_/    ||__|")
                )

                return
            }
        }
    }

    println(
        "|>___/|        /}\n" +
                "| O < |       / }\n" +
                "(==0==)------/ }\n" +
                "| ^  _____    |\n" +
                "|_|_/     ||__|"
    )
}