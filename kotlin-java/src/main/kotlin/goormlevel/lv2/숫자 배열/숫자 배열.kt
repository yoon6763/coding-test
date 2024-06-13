package goormlevel.lv2.`숫자 배열`

fun main() {
    val n = readLine()!!.toInt()
    val arr = Array(n) { i -> Array(n) { j -> i * n + j + 1 } }
    println(arr.joinToString("\n") { it.joinToString(" ") })
}