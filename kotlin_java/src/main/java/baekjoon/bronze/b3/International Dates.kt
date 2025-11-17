package baekjoon.bronze.b3

fun main() {
    val (left, middle, right) = readln().split("/").map { it.toInt() }
    var us = true
    var eu = true
    if (left > 12) {
        us = false
    } else if (middle > 12) {
        eu = false
    }

    if (us && eu) print("either")
    else if (us) print("US")
    else if (eu) print("EU")
}