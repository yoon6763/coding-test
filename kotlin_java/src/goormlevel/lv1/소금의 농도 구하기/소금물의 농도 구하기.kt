package goormlevel.lv1.`소금의 농도 구하기`

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toDouble() }
    val salt = (7 * n) / 100.0
    println(String.format("%.2f", Math.floor((salt / (m + n)) * 100 * 100) / 100))
}