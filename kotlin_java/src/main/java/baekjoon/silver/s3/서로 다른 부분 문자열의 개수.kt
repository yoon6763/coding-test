package baekjoon.silver.s3

fun main() {
    val s = readln()
    val set = mutableSetOf<String>()
    for (i in s.indices)
        for (j in i + 1..s.length)
            set.add(s.substring(i, j))
    println(set.size)
}