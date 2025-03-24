package baekjoon.bronze.b3

fun main() {
    val s = readln()
    var count = 0
    for (i in 0..<s.length - 3) if (s.substring(i, i + 4) == "kick") count++
    println(count)
}
