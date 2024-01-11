package baekjoon.bronze.b4

fun main() {
    var b = 0
    var c = 0
    readln().forEach {
        if (it == 'B') b++
        else c++
    }
    println(b / 2 + c / 2)
}