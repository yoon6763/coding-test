package goormlevel.lv2.`8진수 계산기`

fun main() {
    readLine()
    println(readLine()!!.split(" ").sumOf { it.toInt() }.toString(8))
}