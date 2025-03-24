package baekjoon.bronze.b3


fun main() {
    repeat(readln().toInt()) {
        var answer = 0
        for (i in 1..readln().toInt()) {
            answer += i * (i + 1) * (i + 2) / 2
        }
        println(answer)
    }
}