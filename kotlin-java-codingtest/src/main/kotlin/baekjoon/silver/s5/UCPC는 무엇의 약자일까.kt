package baekjoon.silver.s5

fun main() = with(System.`in`.bufferedReader()) {
    val UCPC = "UCPC"
    val line = readLine()
    var ptr = 0

    for (ch in line) {
        if (ch == UCPC[ptr]) {
            ptr++
        }
        if(ptr == 4) {
            println("I love UCPC")
            return
        }
    }
    println("I hate UCPC")
}