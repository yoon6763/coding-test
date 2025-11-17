package baekjoon.bronze.b3

fun main() {
    var arr = IntArray(3)

    repeat(readln().toInt()) {
        val arr1 = readln().split(" ").map { it.toInt() }
        (0..2).forEach { i -> arr[i] += arr1[i] }
        val min = arr.min()

        if (min < 30) {
            println("NO")
        } else {
            println(min)
            arr = arr.map { it - min }.toIntArray()
        }
    }
}
