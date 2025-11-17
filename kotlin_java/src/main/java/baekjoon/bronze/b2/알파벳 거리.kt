package baekjoon.bronze.b2

fun main() = repeat(readln().toInt()) {
    val (str1, str2) = readln().split(" ")
    val arr = IntArray(str1.length)
    for (j in str1.indices) {
        if (str2[j] < str1[j]) arr[j] = str2[j].code - str1[j].code + 26 else arr[j] = str2[j].code - str1[j].code
    }
    print("Distances: ")
    for (j in arr.indices) {
        print(arr[j].toString() + " ")
    }
    println()
}