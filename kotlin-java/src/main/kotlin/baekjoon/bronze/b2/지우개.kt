package baekjoon.bronze.b2

fun main() {
    var arr = MutableList(readln().toInt()) { it + 1 }
    while (arr.size > 1) {
        val temp = mutableListOf<Int>()
        for (i in 1 until arr.size step 2) temp.add(arr[i])
        arr = temp
    }
    println(arr[0])
}