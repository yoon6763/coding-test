package baekjoon.bronze.b3

fun main() = generateSequence {
    readln().split(" ").map { it.toInt() }.toIntArray().takeIf { it.any { num -> num != 0 } }
}.forEach { arr ->
    if (arr[3] == 0) {
        arr[3] = arr[0] * arr[1] * arr[2]
    } else {
        val origin = arr[3]
        arr[3] = arr.take(3).filter { it != 0 }.fold(arr[3]) { acc, num -> acc / num }
        arr[arr.indices.first { arr[it] == 0 }] = arr[3]
        arr[3] = origin
    }
    println(arr.joinToString(" "))
}
