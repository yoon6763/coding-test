package baekjoon.bronze.b4

fun main() {
    val time = (readln().toInt() + readln().toInt()) % 12
    println(if(time == 0) 12 else time)
}