package baekjoon.bronze.b1

fun main() {
    val height = Array(9) { 0 }
    repeat(9) { height[it] = readLine()!!.toInt() }
    height.sort()
    val sum = height.sum()
    var ptr1 = -1
    var ptr2 = -1
    var isFinish = false
    for (i in 0 until 9) {
        for (j in 0 until 9) {
            if (i == j) continue

            val seven = sum - height[i] - height[j]
            if (seven == 100) {
                ptr1 = i
                ptr2 = j
                isFinish = true
                break
            }
        }
        if (isFinish) break
    }

    repeat(9) { if (it != ptr1 && it != ptr2) println(height[it]) }
}