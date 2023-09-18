package groomthonchallenge.lv2.p4_완벽한햄버거만들기

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map(String::toInt).toIntArray()
    var isDown = false
    for (i in 1 until n) {
        if (arr[i - 1] > arr[i]) {
            isDown = true
        } else if (arr[i - 1] < arr[i]) {
            if (isDown) {
                println(0)
                return
            }
        }
    }

    println(arr.sum())
}