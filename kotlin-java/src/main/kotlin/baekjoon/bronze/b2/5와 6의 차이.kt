package baekjoon.bronze.b2

fun main() {
    val (a,b) = readln().split(" ")
    println("${a.replace("6", "5").toInt()+b.replace("6", "5").toInt()} ${a.replace("5", "6").toInt()+b.replace("5", "6").toInt()}")
}