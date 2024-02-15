package baekjoon.bronze.b1


fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        var count = 0
        val box = Array(n) { readLine().split(" ").map { it.toInt() } }

        for (i in 0..<m) {
            for (j in 0..<n) {
                if (box[j][i] == 1) {
                    for (k in j + 1..<n) {
                        if (box[k][i] == 0) {
                            count++
                        }
                    }
                }
            }
        }

        println(count)
    }
}