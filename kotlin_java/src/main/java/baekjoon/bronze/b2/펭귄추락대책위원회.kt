package baekjoon.bronze.b2

fun main() {
    readln()
    var ans = 0
    val numbers = mutableListOf<Int>()
    readln().split(" ").map { it.toInt() }.forEach {
        if (it == -1) {
            ans += numbers.min()
            numbers.clear()
            return@forEach
        }
        numbers.add(it)
    }

    println(ans + (numbers.min()))
}
