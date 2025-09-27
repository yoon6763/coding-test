package baekjoon.bronze.b1

fun main() {
    val (x1b1, y1b1, x2b1, y2b1) = readln().split(" ").map { it.toInt() }
    val (x1b2, y1b2, x2b2, y2b2) = readln().split(" ").map { it.toInt() }
    val (x1t, y1t, x2t, y2t) = readln().split(" ").map { it.toInt() }
    val area = { x1: Int, y1: Int, x2: Int, y2: Int -> (x2 - x1) * (y2 - y1) }
    val overlap = { x1a: Int, y1a: Int, x2a: Int, y2a: Int, x1b: Int, y1b: Int, x2b: Int, y2b: Int -> maxOf(0, minOf(x2a, x2b) - maxOf(x1a, x1b)) * maxOf(0, minOf(y2a, y2b) - maxOf(y1a, y1b)) }
    println((area(x1b1, y1b1, x2b1, y2b1) - overlap(x1b1, y1b1, x2b1, y2b1, x1t, y1t, x2t, y2t)) + (area(x1b2, y1b2, x2b2, y2b2) - overlap(x1b2, y1b2, x2b2, y2b2, x1t, y1t, x2t, y2t)))
}
