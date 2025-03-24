package baekjoon.silver.s1

var c = 0L

fun main() {
    val line = readLine()!!.split(" ")
    val a = line[0].toLong()
    val b = line[1].toLong()
    c = line[2].toLong()

    println(solve(a, b))
}

fun solve(a: Long, b: Long): Long {
    if (b == 1.toLong()) {
        return a % c
    }

    val half = solve(a, b / 2)

    return if (b % 2 == 1.toLong()) {
        (half * half % c) * a % c
    } else {
        half * half % c
    }
}