package baekjoon.bronze.b2

fun main() {
    readln()
    val str = readln().replace("J", "").replace("A", "").replace("V", "")
    if(str.isEmpty()) println("nojava")
    else println(str)
}