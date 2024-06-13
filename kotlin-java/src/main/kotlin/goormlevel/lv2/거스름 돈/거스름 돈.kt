package goormlevel.lv2.`거스름 돈`

fun main() {
    var n = readLine()!!.toLong()
    val type = arrayOf(40L, 20L, 10L, 5L, 1L)

    var cnt = 0L
    type.forEach {
        cnt += (n / it)
        n %= it
    }
    println(cnt)
}