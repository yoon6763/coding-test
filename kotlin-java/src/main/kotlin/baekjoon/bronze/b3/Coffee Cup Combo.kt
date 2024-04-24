package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val arr = readln()
    val flag = BooleanArray(n)
    repeat(n) {
        if (arr[it] == '1') {
            flag[it] = true
            if (it + 1 < n) flag[it + 1] = true
            if (it + 2 < n) flag[it + 2] = true
        }
    }
    println(flag.count { it })
}