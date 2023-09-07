package groomthonchallenge.p1_운동중독플레이어

fun main() {
    val (w, r) = readLine()!!.split(" ").map(String::toDouble)
    println((w * (1 + r / 30)).toInt())
}