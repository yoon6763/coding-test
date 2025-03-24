package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val stack = mutableListOf<Int>()
    stack.add(readln().toInt())
    for (i in 0..<n) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        stack.add(stack[i] + a - b)
    }
    for (i in 0..n) {
        if (stack[i] < 0) {
            println(0)
            return
        }
    }
    println(stack.maxOrNull())
}
