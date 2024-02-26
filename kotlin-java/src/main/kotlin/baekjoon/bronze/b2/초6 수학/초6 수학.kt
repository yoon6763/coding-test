package baekjoon.bronze.b2.`초6 수학`

fun main() {
    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ").map(String::toInt).sorted()
        println("${lcm(a, b)} ${gcd(a, b)}")
    }
}

fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
fun lcm(a: Int, b: Int): Int = a * b / gcd(a, b)
