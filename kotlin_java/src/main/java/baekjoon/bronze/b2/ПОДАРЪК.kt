package baekjoon.bronze.b2

fun main() {
    val str = readln()
    val alphabet = str.filter { it.isLetter() }.toList().sorted()
    val num = str.filter { it.isDigit() }.toList().sortedDescending()
    repeat(6) {
        print(if (it % 2 == 0) alphabet[it / 2] else num[it / 2])
    }
}