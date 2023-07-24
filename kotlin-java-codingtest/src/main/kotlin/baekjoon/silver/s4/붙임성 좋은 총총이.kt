package baekjoon.silver.s4

fun main() = with(System.`in`.bufferedReader()) {
    val set = HashSet<String>()
    set.add("ChongChong")

    repeat(readLine().toInt()) {
        val (a, b) = readLine().split(" ")
        if (a in set) set.add(b)
        if (b in set) set.add(a)
    }
    println(set.size)
}