package baekjoon.bronze.b3

fun main() {
    val arr1 = IntArray(4) { readln().toInt() }.sorted()
    val arr2 = readln().toInt()
    println(if ((arr1[0] == arr1[1] || arr1[0] + arr2 == arr1[1]) && arr1[1] == arr1[3]) 1 else 0)
}