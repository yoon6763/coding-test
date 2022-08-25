package baekjoon.bronze.b5

fun main() {
    var result = 0L

    repeat(5) {
        result += readLine()!!.toInt()
    }
    println(result)
}