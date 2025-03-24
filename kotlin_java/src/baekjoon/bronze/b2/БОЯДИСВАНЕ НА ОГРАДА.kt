package baekjoon.bronze.b2

fun main() {
    var (l1, r1, l2, r2) = readln().split(" ").map { it.toInt() }
    if (l1 > r1) l1 = r1.also { r1 = l1 }
    if (l2 > r2) l2 = r2.also { r2 = l2 }
    println(if ((r1 in l2..r2) || (r2 in l1..r1)) maxOf(r1, r2) - minOf(l1, l2) + 1 else (r1 - l1) + 1 + (r2 - l2) + 1)
}