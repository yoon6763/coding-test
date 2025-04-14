package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val s1 = generateSequence(1L) { it + 1 }.take(b).sum()
    val s2 = generateSequence(1L) { it + 2 }.take(b).sum()
    val s3 = generateSequence(2L) { it + 2 }.take(b).sum()
    println("$a $s1 $s2 $s3")
}