package goormlevel.lv1.`운동 중독 플레이어`

fun main() {
    val (w, r) = readLine()!!.split(" ").map(String::toDouble)
    println((w * (1 + r / 30)).toInt())
}