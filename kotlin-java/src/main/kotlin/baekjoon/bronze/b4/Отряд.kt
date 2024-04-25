package baekjoon.bronze.b4

fun main() {
    val arr1 = readln()
    val arr2 = readln()
    for(i in arr1.indices) {
        print(maxOf(arr1[i].digitToInt(), arr2[i].digitToInt()))
    }
}