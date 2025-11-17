package baekjoon.bronze.b2

fun main() {
    val n = readln()

    if (n.startsWith("0x")) println(n.replace("0x", "").toInt(16))
    else if (n.startsWith("0")) println(n.replaceFirst("0", "").toInt(8))
    else println(n)
}