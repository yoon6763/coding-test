package baekjoon.bronze.b2

fun main() {
    val arr = readln().split(" ").map(String::toInt)
    for(i in 1 until arr.size) {
        if(arr[i - 1] > arr[i]) {
            println("Bad")
            return
        }
    }
    println("Good")
}