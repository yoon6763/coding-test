package goormlevel.lv2.`밀도 정렬`

data class Object(val id: Int, val weight: Int, val volume: Int, val density: Double)

fun main() = print(List(readLine()!!.toInt()) {
    val (w, v) = readLine()!!.split(" ").map { it.toInt() }
    Object(it + 1, w, v, w.toDouble() / v.toDouble())
}.sortedWith(compareBy({ -it.density }, { -it.weight }, { it.id }))[0].id)