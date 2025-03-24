package baekjoon.bronze.b4

fun main() {
    var result = 0
    while (true) {
        val n = readLine()!!.toInt()
        if(n == -1) break else result += n
    }
    println(result)
}