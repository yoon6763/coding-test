package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    for(i in 1 .. 9999) {
        if(1 + i + i * i== n) {
            println(i)
            return
        }
    }
}