package baekjoon.bronze.b3

fun main() {
    val list = Array(6) { readln().let { if (it.endsWith(" ")) it.length - 1 else it.length } }
    println("Latitude ${list[0]}:${list[1]}:${list[2]}")
    println("Longitude ${list[3]}:${list[4]}:${list[5]}")
}
