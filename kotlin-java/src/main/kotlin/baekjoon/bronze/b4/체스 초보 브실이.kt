package baekjoon.bronze.b4

fun main() {
    val map = hashMapOf('k' to 0, 'p' to 1, 'n' to 3, 'b' to 3, 'r' to 5, 'q' to 9)
    var white = 0
    var black = 0

    repeat(8) {
        readln().forEach {
            if (it.isUpperCase()) white += map[it.lowercaseChar()]!! else black += map.getOrDefault(it, 0)
        }
    }
    println(white - black)
}