package baekjoon.silver.s3

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        try {
            val n = readLine().toInt()
            var k = 1
            var ans = 1

            while (true) {
                if (ans % n == 0) {
                    break
                } else {
                    k++
                    ans = (ans * 10 + 1) % n
                }
            }
            println(k)
        } catch (e: Exception) {
            break
        }
    }
}