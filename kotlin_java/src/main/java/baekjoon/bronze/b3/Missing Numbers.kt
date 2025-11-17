package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = BooleanArray(201)
    var max = 0
    repeat(n) {
        val num = readLine().toInt()
        arr[num] = true
        max = maxOf(max, num)
    }
    var flag = false
    for (i in 1..max) {
        if (!arr[i]) {
            println(i)
            flag = true
        }
    }
    if (!flag) println("good job")
}