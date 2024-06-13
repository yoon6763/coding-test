package goormlevel.lv1.`최장 맨해튼 거리`

fun main() {
    val (a, b, c, d) = readLine()!!.split(" ").map { it.toInt() }.sorted()
    println(c - a + d - b)
}