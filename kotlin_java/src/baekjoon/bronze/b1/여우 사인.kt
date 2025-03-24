package baekjoon.bronze.b1

fun main() {
    val arr = Array(6) { IntArray(6) }

    val n = readln().toInt()
    if (n != 3) {
        println("Woof-meow-tweet-squeek")
    } else {
        repeat(n) {
            val (x, y) = readln().split(" ").map { it.toInt() }
            arr[x][y] = 1
            arr[y][x] = 1
        }
        println(if (arr[1][3] == 1 && arr[3][4] == 1 && arr[4][1] == 1) "Wa-pa-pa-pa-pa-pa-pow!" else "Woof-meow-tweet-squeek")
    }
}