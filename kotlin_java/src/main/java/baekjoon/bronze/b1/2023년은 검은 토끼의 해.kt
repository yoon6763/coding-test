package baekjoon.bronze.b1

fun main() {
    val target = "2023"
    val targetLength = target.length
    var ans = 0

    for (i in 1..readln().toInt()) {
        val s = i.toString()
        var idx = 0
        for (ch in s) {
            if (ch == target[idx]) idx++
            if (idx == targetLength) {
                ans++
                break
            }
        }
    }

    println(ans)
}