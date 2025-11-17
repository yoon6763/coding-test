package baekjoon.bronze.b3

fun main() {
    for (i in 1..readln().trim().toInt()) {
        when {
            i % 3 == 0 && i % 5 == 0 -> print("DeadMan ")
            i % 3 == 0 -> print("Dead ")
            i % 5 == 0 -> print("Man ")
            else -> print("$i ")
        }
    }
}