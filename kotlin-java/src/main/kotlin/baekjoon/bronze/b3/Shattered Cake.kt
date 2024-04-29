package baekjoon.bronze.b3

fun main() {
    val w = readln().toInt()
    val t = readln().toInt()

    var sum = 0
    repeat(t) {
        val (wi, li) = readln().split(" ").map { it.toInt() }
        sum += wi * li
    }

    for(l in 1 .. 9999999) {
        if(w * l == sum) {
            println(l)
            break
        }
    }
}