package groomthonchallenge.p3_합계산기

fun main() = with(System.`in`.bufferedReader()) {
    println(Array(readLine().toInt()) {
        val (a, oper, b) = readLine().split(" ")
        when (oper) {
            "+" -> a.toInt() + b.toInt()
            "-" -> a.toInt() - b.toInt()
            "*" -> a.toInt() * b.toInt()
            "/" -> a.toInt() / b.toInt()
            else -> 0
        }
    }.sum())
}