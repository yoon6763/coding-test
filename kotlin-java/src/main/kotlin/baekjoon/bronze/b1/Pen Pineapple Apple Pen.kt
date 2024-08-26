package baekjoon.bronze.b1

fun main() {
    readln()
    print(readln().replace("pPAp", ".").count { it == '.' })
}