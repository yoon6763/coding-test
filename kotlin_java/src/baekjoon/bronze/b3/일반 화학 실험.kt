package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    var temp = readLine().toDouble()
    while (true) {
        val newTemp = readLine().toDouble()
        if (newTemp == 999.0) break
        println("%.2f".format(newTemp - temp))
        temp = newTemp
    }
}