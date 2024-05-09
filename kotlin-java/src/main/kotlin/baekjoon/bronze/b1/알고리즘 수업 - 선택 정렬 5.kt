package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.toIntArray()
    val target = readln().split(" ").map { it.toInt() }.toIntArray()

    for (i in n - 1 downTo 1) {
        if (arr.contentEquals(target)) {
            break
        }
        val idx = arr.indexOf(arr.sliceArray(0..i).max())
        if (idx != i) {
            val temp = arr[idx]
            arr[idx] = arr[i]
            arr[i] = temp
        }
    }

    println(if (arr.contentEquals(target)) 1 else 0)
}
