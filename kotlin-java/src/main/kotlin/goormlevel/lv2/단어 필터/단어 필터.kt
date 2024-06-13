package goormlevel.lv2.`단어 필터`

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val str1 = readLine()!!
    var str2 = readLine()!!
    while (str1 in str2) {
        str2 = str2.replaceFirst(str1, "")
    }
    println(str2.ifEmpty { "EMPTY" })
}