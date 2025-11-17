package baekjoon.silver.s1.최대공약수

fun main() {
    val (a, b) = readln().split(" ").map(String::toLong).sorted()
    val sb = StringBuilder()
    for (i in 0 until gcd(a, b)) sb.append(1)
    println(sb)
}

fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)