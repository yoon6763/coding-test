package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val line = readln().split(" ")
    when (line[1]) {
        "kg" -> println("%.4f".format(line[0].toDouble() * 2.2046) + " lb")
        "lb" -> println("%.4f".format(line[0].toDouble() * 0.4536) + " kg")
        "l" -> println("%.4f".format(line[0].toDouble() * 0.2642) + " g")
        "g" -> println("%.4f".format(line[0].toDouble() * 3.7854) + " l")
    }
}