package goormlevel.lv1.`큰 팩토리얼`

fun main() {
    val input = readLine()!!.toInt()
    var sum = 1L

    for (i in 2..input) {
        sum *= i.toLong()
        sum %= 1000000007
    }
    println(sum)
}