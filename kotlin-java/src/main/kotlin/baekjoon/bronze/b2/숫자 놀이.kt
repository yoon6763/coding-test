package baekjoon.bronze.b2

fun main() {
    while (true) {
        var n = readln().toInt()
        if (n == 0) break

        while (n >= 10) {
            var temp = 0

            while (n > 0) {
                temp += n % 10
                n /= 10
            }

            n = temp
        }

        println(n)
    }
}