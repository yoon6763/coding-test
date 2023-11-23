package baekjoon.bronze.b2

fun main() {
    repeat(readln().toInt()) {
        val (str1, str2) = readln().split(" ")
        if (str1.toCharArray().sorted().joinToString("") == str2.toCharArray().sorted().joinToString("")) {
            println("Possible")
        } else {
            println("Impossible")
        }
    }
}