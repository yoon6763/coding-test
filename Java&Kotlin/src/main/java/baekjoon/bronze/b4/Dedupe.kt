package baekjoon.bronze.b4

fun main() {
    repeat(readln().toInt()) {
        var line = readln()
        var pre = line[0]

        for (i in 1 until line.length) {
            if (line[i] != pre) {
                print(pre)
                pre = line[i]
            }
        }
        println(pre)
    }
}