package baekjoon.bronze.b3

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val arr = ArrayList<Int>()

    for (i in 1..n) if ((i % 10) != (k % 10) && (i % 10) != ((2 * k) % 10)) arr.add(i)

    println(arr.size)
    println(arr.joinToString(" "))
}
