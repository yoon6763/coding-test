package goormlevel.lv1.`프로젝트 매니징`

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var (t, m) = readLine().split(" ").map(String::toInt)
    repeat(n) {
        val plus = readLine().toInt()
        m += plus
        t += m / 60
        m %= 60
        t %= 24
    }
    println("$t $m")
}