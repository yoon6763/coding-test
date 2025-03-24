package baekjoon.bronze.b4

fun main() {
    var cnt = 0;
    repeat(readln().toInt()) {
        if(readln().filter { it.isDigit() }.toInt() <= 90) cnt++
    }
    println(cnt)
}