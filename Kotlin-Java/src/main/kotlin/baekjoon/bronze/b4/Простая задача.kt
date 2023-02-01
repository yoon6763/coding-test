package baekjoon.bronze.b4

fun main() {
    val n = readLine()!!.toInt()

    repeat(n) {
        val line = readLine()!!.split(" ").map { it.toInt() }

        if((line[0] <= 2 && line[1] <= 1 )||(line[0] <= 1 && line[1] <= 2) ) {
            println("Yes")
        } else {
            println("No")
        }
    }
}