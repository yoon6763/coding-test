package baekjoon.bronze.b4

fun main() {
    while(true) {
        val line = readLine()!!
        if(line == "END") break
        println(line.reversed())
    }
}