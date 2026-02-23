package baekjoon.bronze.b3

fun main() {
    val count = IntArray(26)
    readln().forEach { count[it - 'a']++ }

    var allEven = true
    var allOdd = true

    count.forEach {
        if (it == 0) return@forEach
        if (it % 2 == 0) allOdd = false else allEven = false
    }

    println(
        when {
            allEven -> 0
            allOdd -> 1
            else -> 2
        }
    )
}