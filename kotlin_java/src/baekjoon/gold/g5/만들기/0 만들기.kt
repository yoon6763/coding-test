package baekjoon.gold.g5.만들기

fun main() = repeat(readln().toInt()) {
    fun func(n: Int, depth: Int, buffer: Int, sum: Int, oper: Int, expr: String) {
        if (depth == n) {
            if (sum + buffer * oper == 0) println(expr)
            return
        }
        func(n, depth + 1, buffer * 10 + depth + 1, sum, oper, "$expr ${depth + 1}")
        func(n, depth + 1, depth + 1, sum + buffer * oper, 1, "$expr+${depth + 1}")
        func(n, depth + 1, depth + 1, sum + buffer * oper, -1, "$expr-${depth + 1}")
    }
    func(readln().toInt(), 1, 1, 0, 1, "1")
    println()
}