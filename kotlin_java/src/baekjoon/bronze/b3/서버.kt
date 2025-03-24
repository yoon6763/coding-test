package baekjoon.bronze.b3

fun main() {
    var (n, t) = readln().split(" ").map { it.toInt() }
    var count = 0

    val nums = readln().split(" ").map { it.toInt() }

    for (i in 0..<n) {
        val need = nums[i]
        if (t >= need) {
            t -= need
            count++
        } else {
            break
        }
    }
    println(count)
}