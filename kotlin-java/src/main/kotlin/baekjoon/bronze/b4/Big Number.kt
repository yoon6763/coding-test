package baekjoon.bronze.b4

fun main() {
    val line = readLine()!!
    for (i in line.indices) {
        when(line[i]) {
            '0' -> {
                println("0000")
                println("0  0")
                println("0  0")
                println("0  0")
                println("0000")
            }
            '1' -> {
                println("   1")
                println("   1")
                println("   1")
                println("   1")
                println("   1")
            }
            '2' -> {
                println("2222")
                println("   2")
                println("2222")
                println("2")
                println("2222")
            }
            '3' -> {
                println("3333")
                println("   3")
                println("3333")
                println("   3")
                println("3333")
            }
            '4' -> {
                println("4  4")
                println("4  4")
                println("4444")
                println("   4")
                println("   4")
            }
            '5' -> {
                println("5555")
                println("5")
                println("5555")
                println("   5")
                println("5555")
            }
            '6' -> {
                println("6666")
                println("6")
                println("6666")
                println("6  6")
                println("6666")
            }
            '7' -> {
                println("7777")
                println("   7")
                println("   7")
                println("   7")
                println("   7")
            }
            '8' -> {
                println("8888")
                println("8  8")
                println("8888")
                println("8  8")
                println("8888")
            }
            '9' -> {
                println("9999")
                println("9  9")
                println("9999")
                println("   9")
                println("   9")
            }
        }
        if(i != line.length - 1) {
            println()
        }
    }
}