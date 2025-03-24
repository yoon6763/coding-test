package baekjoon.bronze.b4

fun main() {
    val arr = readln().split(" ").map(String::toInt).sorted()
    println(arr[1] + arr[2])
}