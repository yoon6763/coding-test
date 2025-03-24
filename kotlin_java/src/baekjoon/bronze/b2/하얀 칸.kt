package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    var count = 0
    for (i in 0 until 8) {
        val line = readLine()
        for (j in 0 until 8) {
            if (i % 2 == 0 && j % 2 == 0 && line[j] == 'F') {
                count++
            } else if (i % 2 == 1 && j % 2 == 1 && line[j] == 'F') {
                count++
            }
        }
    }
    print(count)
}