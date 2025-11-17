package baekjoon.bronze.b4

fun main() {
    val arr1 = readln().split(" ").map { it.toInt() }
    val arr2 = readln().split(" ").map { it.toInt() }
    println(if (arr1[0] * 13 + arr1[1] * 7 + arr1[2] * 5 + arr1[3] * 3 + arr1[4] * 3 + arr1[5] * 2 > arr2[0] * 13 + arr2[1] * 7 + arr2[2] * 5 + arr2[3] * 3 + arr2[4] * 3 + arr2[5] * 2 + 1.5) "cocjr0208" else "ekwoo")
}
