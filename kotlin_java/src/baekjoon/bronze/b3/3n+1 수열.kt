package baekjoon.bronze.b3

fun main() {
    var n = readln().toInt()
    var i = 1L
    if(n == 1) {
        println(1)
        return
    }
    while (true) {
        if (n % 2 == 0) {
            n /= 2
        } else {
            n = n * 3 + 1
        }
        i++

        if (n == 1) {
            println(i)
            break
        }
    }
}