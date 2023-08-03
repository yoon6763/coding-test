package baekjoon.bronze.b1

fun main() {
    var n = readln().toInt()
    while (true) {
        val string = n.toString().toCharArray()
        if (string.size == string.count { it == '4' || it == '7' }) break
        n--
    }
    println(n)
}