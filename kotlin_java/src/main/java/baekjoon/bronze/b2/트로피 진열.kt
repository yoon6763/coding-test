package baekjoon.bronze.b2

fun main() {
    val arr = List(readln().toInt()) { readln().toInt() }

    fun count(list: List<Int>): Int {
        var count = 0
        var max = 0
        for (i in list) {
            if (i > max) {
                max = i
                count += 1
            }
        }
        return count
    }

    println(count(arr))
    println(count(arr.asReversed()))
}