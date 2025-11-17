package baekjoon.bronze.b1

fun main()= repeat(readln().toInt()) { println("$${readln().split(" ").sumOf { mapOf("Franklin" to 100, "Grant" to 50, "Jackson" to 20, "Hamilton" to 10, "Lincoln" to 5, "Washington" to 1)[it]!! }}") }
