package baekjoon.bronze.b2

fun main() {
    readln()
    print(readln().toCharArray().let { if ((0..<it.size - 1).all { i -> it[i] != it[i + 1] }) "Yes" else "No" })
}
