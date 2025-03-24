package baekjoon.bronze.b2

fun main() {
    var n = readln().toInt()

    repeat(n) {
        var sum = 0
        while (n > 0) {
            sum += (n % 10) * (n % 10)
            n /= 10
        }

        if (sum == 1) {
            println("HAPPY")
            return
        }
        n = sum
    }

    println("UNHAPPY")
}