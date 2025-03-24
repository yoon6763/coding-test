package baekjoon.bronze.b2

fun main() {
    repeat(readln().toInt()) {
        val input = readln().split(" ")
        when(input[1]) {
            "*" -> if (input[0].toLong() * input[2].toLong() == input[4].toLong()) println("correct") else println("wrong answer")
            "+" -> if (input[0].toLong() + input[2].toLong() == input[4].toLong()) println("correct") else println("wrong answer")
            "-" -> if (input[0].toLong() - input[2].toLong() == input[4].toLong()) println("correct") else println("wrong answer")
            "/" -> if (input[0].toLong() / input[2].toLong() == input[4].toLong()) println("correct") else println("wrong answer")
        }
    }
}