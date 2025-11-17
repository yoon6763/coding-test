package baekjoon.silver.s3

fun main(): Unit = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val hashSet = HashSet<String>()

    repeat(n) {
        hashSet.add(readLine())
    }

    var cnt = 0
    repeat(m) {
        if (hashSet.contains(readLine())) cnt++
    }

    println(cnt)
}