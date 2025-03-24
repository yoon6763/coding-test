package baekjoon.bronze.b4

fun main() {
    readln()
    readln().split(" ").let { val h = readln(); print(it.count { it == h }) }
}