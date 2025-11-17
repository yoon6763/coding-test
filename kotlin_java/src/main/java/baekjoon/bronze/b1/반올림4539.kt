package baekjoon.bronze.b1

fun main() = repeat(readln().toInt()) {
    val arr = readln().toCharArray().map { it.digitToInt() }.toIntArray()
    for (i in arr.size - 1 downTo 1) {
        if (arr[i] > 4) arr[i - 1] += 1
        arr[i] = 0
    }
    println(arr.joinToString(""))
}