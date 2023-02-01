package baekjoon.bronze.b3

fun main() {
    repeat(readln().toInt()) {
        var line = readln().toCharArray()
        line[0] = line[0].uppercaseChar()
        println(line)
    }
}