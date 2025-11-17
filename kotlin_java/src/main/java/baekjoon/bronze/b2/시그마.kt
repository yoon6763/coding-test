package baekjoon.bronze.b2

fun main() {
    val line = readLine()!!.split(" ")
    var a = line[0].toLong()
    var b = line[1].toLong()

    var result:Long =
        if (a < b) (b * (b + 1)) / 2 - (a * (a - 1) / 2)
        else (a * (a + 1)) / 2 - (b * (b - 1) / 2)

    print(result)
}