package baekjoon.bronze.b4

fun main() {
    val arr = Array(3) { readln().toInt() }
    if(arr.sum() != 180) {
        println("Error")
    } else {
        when {
            arr[0] == arr[1] && arr[1] == arr[2] -> println("Equilateral")
            arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2] -> println("Isosceles")
            else -> println("Scalene")
        }
    }
}