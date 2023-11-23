package baekjoon.bronze.b3

fun main() {
    readln()
    val line = readLine()!!.replace("security", "s").replace("bigdata", "b")
    val s = line.count { it == 's' }
    val b = line.count { it == 'b' }
    println(if (s > b) "security!" else if (s < b) "bigdata?" else "bigdata? security!")
}