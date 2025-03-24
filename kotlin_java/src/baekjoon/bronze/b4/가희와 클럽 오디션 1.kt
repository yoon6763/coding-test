package baekjoon.bronze.b4

fun main() {
    val nm = readln().split(" ")
    val n = nm[0].toInt()
    val m = nm[1]

    println(
        when (m) {
            "miss" -> 0
            "bad" -> n * 200
            "cool" -> n * 400
            "great" -> n * 600
            "perfect" -> n * 1000
            else -> 0
        }
    )
}
