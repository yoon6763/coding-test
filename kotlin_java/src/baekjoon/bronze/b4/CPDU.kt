package baekjoon.bronze.b4

fun main() {
    val n = readln().toInt()
    var answer = 0
    repeat(n) {
        if (readln().startsWith('C')) answer++
    }
    println(answer)
}
