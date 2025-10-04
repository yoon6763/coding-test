package baekjoon.bronze.b4

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    var current = 0
    var saved: Int? = null

    repeat(n) {
        when (readln().trim()) {
            "ammo" -> current += k
            "shoot" -> current -= 1
            "save" -> saved = current
            "load" -> current = saved ?: 0
        }
        println(current)
    }
}
