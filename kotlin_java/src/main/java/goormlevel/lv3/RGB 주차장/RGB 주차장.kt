package goormlevel.lv3.`RGB 주차장`

fun main() {
    val n = readLine()!!.toInt()
    var ans = 3

    for (i in 1 until n) {
        ans = (ans * 2) % 100000007
    }

    println(ans)
}