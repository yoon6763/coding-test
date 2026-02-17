package baekjoon.bronze.b3

fun main() {
    val t = readln().toInt()
    repeat(t) { caseIndex ->
        val m = readln().toInt()
        val words = readln().split(" ")
        val count = words.count { it == "sheep" }
        println("Case ${caseIndex + 1}: This list contains $count sheep.")
        println()
    }
}