package baekjoon.bronze.b4

fun main() {
    while (true) {
        val nm = readLine()!!.split(" ").map { it.toInt() }
        val result = nm[0] + nm[1]
        if(result == 0) break else println(result)
    }
}