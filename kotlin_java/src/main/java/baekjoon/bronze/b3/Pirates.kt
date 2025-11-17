package baekjoon.bronze.b3

fun main() {
    readln(); println(readln().groupBy { it }.map { it.key to it.value.size }.maxBy { it.second }.let { "${it.first} ${it.second}" })
}