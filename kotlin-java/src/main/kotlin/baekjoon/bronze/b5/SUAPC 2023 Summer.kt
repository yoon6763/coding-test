package baekjoon.bronze.b5

fun main() {
    val pro = listOf(12, 11, 11, 10, 9, 9, 9, 8, 7, 6, 6)
    val pan = listOf(1600, 894, 1327, 1311, 1004, 1178, 1357, 837, 1055, 556, 773)

    val N = readln().toInt()

    println("${pro[N-1]} ${pan[N-1]}")
}