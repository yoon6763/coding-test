package baekjoon.silver.s3

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val line = readLine()
    val arr = Array(n) { readLine().toDouble() }
    val stack = ArrayDeque<Double>()

    line.forEach {
        if (it in 'A'..'Z') {
            stack.add(arr[it - 'A'])
            return@forEach
        }

        if (stack.isEmpty()) {
            return@forEach
        }

        val b = stack.removeLast()
        val a = stack.removeLast()

        when (it) {
            '+' -> stack.add(a + b)
            '-' -> stack.add(a - b)
            '*' -> stack.add(a * b)
            '/' -> stack.add(a / b)
        }
    }

    println("%.2f".format(stack.removeLast()))
}