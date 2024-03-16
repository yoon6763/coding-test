package baekjoon.bronze.b3

fun main() {
    val arr = readln().split(" ").map { it.toInt() }.sorted()

    val diff1 = arr[1] - arr[0]
    val diff2 = arr[2] - arr[1]

    if (diff1 == diff2) {
        println(arr[2] + diff1)
    } else {
        if (diff1 > diff2) {
            println(arr[0] + diff2)
        } else {
            println(arr[1] + diff1)
        }
    }
}