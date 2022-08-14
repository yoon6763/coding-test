package baekjoon.bronze.b5

fun main() {
    val line1 = readLine()!!
    val line2 = readLine()!!

    print(if(line1.length < line2.length) "no" else "go")
}