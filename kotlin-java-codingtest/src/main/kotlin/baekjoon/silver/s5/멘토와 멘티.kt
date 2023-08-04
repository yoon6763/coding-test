package baekjoon.silver.s5

fun main() = Array(readln().toInt()) {
    val input = readln().split(" ")
    Pair(input[0], input[1])
}.sortedWith(compareBy<Pair<String, String>> { it.first }.thenByDescending { it.second }).forEach {
    println("${it.first} ${it.second}")
}
