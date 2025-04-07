package baekjoon.bronze.b2

fun main() {
    val (ml, mr, tl, tr) = readln().split(" ")
    if (ml != mr && tl != tr) return println("?")
    val winMap = mapOf("S" to "R", "R" to "P", "P" to "S")
    if (ml == mr && tl != tr) return println(if (winMap[ml] in listOf(tl, tr)) "TK" else "?")
    if (ml != mr && tl == tr) return println(if (winMap[tl] in listOf(ml, mr)) "MS" else "?")

    println(when {
        winMap[ml] == tl -> "TK"
        winMap[tl] == ml -> "MS"
        else -> "?"
    })
}
