package baekjoon.bronze.b1

fun main() {
    val str = readln()
    var star = -1
    var sum = 0

    for (i in 0 until str.length) {
        if (str[i] == '*') star = i else sum += (str[i] - '0') * if (i % 2 == 0) 1 else 3
    }

    for (i in 0..9) {
        if ((sum + i * if (star % 2 == 0) 1 else 3) % 10 == 0) {
            println(i)
            return
        }
    }
}