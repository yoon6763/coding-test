package baekjoon.bronze.b3

fun main() {
    var n = readln().toInt()
    var a = 0
    var b = 0
    var flag = false

    while (n > 0) {
        val x = n - n / 2
        if (flag) a += x else b += x
        flag = !flag
        n /= 2
    }

    println("$a $b")
}
