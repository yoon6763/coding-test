package baekjoon.silver.s2.`창고 다각형`

class Block(val x: Int, val y: Int) {
    constructor(map: List<Int>) : this(map[0], map[1])
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    // 위치, 높이
    val arr = Array(n) { Block(readLine().split(" ").map { it.toInt() }) }.sortedBy { it.x }
    val container = IntArray(arr.last().x + 1) { 0 }

    var maxHeight = arr[0].y
    var index = arr[0].x

    for (i in 0..<n) {
        if (maxHeight <= arr[i].y) {
            for (j in index..<arr[i].x) {
                container[j] = maxHeight
            }
            maxHeight = arr[i].y
            index = arr[i].x
        }
    }

    maxHeight = arr.last().y
    index = arr.last().x

    for (i in n - 1 downTo 0) {
        if (maxHeight <= arr[i].y) {
            for (j in index downTo arr[i].x) {
                container[j] = maxHeight
            }
            maxHeight = arr[i].y
            index = arr[i].x
        }
    }

    container[index] = arr.maxOf { it.y }
    println(container.sum())
}