package baekjoon.bronze.b3

fun main() {
    val (x, y, n) = readln().split(" ").map { it.toInt() }
    for (i in 1..n) println(if (i % x == 0 && i % y == 0) "FizzBuzz" else if (i % x == 0) "Fizz" else if (i % y == 0) "Buzz" else i)
}