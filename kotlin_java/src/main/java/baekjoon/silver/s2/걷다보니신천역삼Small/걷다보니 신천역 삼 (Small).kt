package baekjoon.silver.s2.걷다보니신천역삼Small

fun main() = println(solve(readln().toInt(), 0, 0))

fun solve(n: Int, depth: Int, cur: Int): Int {
    if (depth == n) return if (cur % 3 == 0) 1 else 0
    return (0..2).filterNot { depth == 0 && it == 0 }.sumOf { solve(n, depth + 1, cur * 10 + it) }
}