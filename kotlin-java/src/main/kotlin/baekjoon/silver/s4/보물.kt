package baekjoon.silver.s4

fun main() {
    val length = readLine()!!.toInt()
    var strarr1 = readLine()!!.split(" ")
    var strarr2 = readLine()!!.split(" ")

    var arr1 = strarr1.map { it.toInt() }.sorted()
    var arr2 = strarr2.map { it.toInt() }.sorted().reversed()

    var result1 = 0

    for (i in 0..length - 1)
        result1 += arr1[i] * arr2[i]

    print(result1)
}