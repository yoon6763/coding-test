package baekjoon.bronze.b4

fun main() {
    val alarm = readln().split(":")
    val now = readln().split(":")

    val a = alarm[0].toInt() * 60 + alarm[1].toInt()
    val b = now[0].toInt() * 60 + now[1].toInt()

    if (b > a) {
        println("YES")
    } else {
        println("NO")
    }
}
