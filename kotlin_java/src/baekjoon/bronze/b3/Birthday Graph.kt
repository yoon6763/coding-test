package baekjoon.bronze.b3

fun main() {
    for (i in 1..9) {
        val n = readln().trim().toInt()
        if (n == 0) break
        val month = Array(13) { 0 }
        repeat(n) { month[readln().split(" ")[1].toInt()]++ }
        println("Case #${i}:")
        val label = arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
        for (i in 1..12) {
            println("${label[i - 1]}:${"*".repeat(month[i])}")
        }
    }
}