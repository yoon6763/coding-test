package baekjoon.bronze.b4

fun main() {
    var start = readln().toInt()
    val end = readln().toInt()

    while (start <= end) {
        println("All positions change in year $start")
        start += 60
    }
}