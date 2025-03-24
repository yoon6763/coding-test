package baekjoon.bronze.b3

fun main() {
    repeat(readln().toInt()) {
        val arr = readln().split(" ").map { it.toInt() }.sorted()

        if (arr[0] + arr[1] <= arr[2]) {
            println("Case #${it+1}: invalid!")
        } else if (arr[0] == arr[1] && arr[0] == arr[2]) {
            println("Case #${it+1}: equilateral")
        } else if (arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2]) {
            println("Case #${it+1}: isosceles")
        } else {
            println("Case #${it+1}: scalene")
        }
    }
}