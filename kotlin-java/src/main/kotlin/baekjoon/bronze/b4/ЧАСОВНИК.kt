package baekjoon.bronze.b4

fun main() {
    var (t1, m1, t2, m2) = readln().split(" ").map(String::toInt)
    m1 += t1 * 60
    m2 += t2 * 60
    if (m2 < m1) m2 += 24 * 60
    println("${m2 - m1} ${(m2 - m1)/30}")
}