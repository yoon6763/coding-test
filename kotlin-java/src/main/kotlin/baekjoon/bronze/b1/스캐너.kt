package baekjoon.bronze.b1

fun main() {
    val (n, m, zn, zm) = readln().split(" ").map { it.toInt() }
    val map = List(n) { readln() }
    val sb = StringBuilder()
    for (i in 0..<n) {
        repeat(zn) {
            for (j in 0..<m) {
                repeat(zm) {
                    sb.append(map[i][j])
                }
            }
            sb.append("\n")
        }
    }
    print(sb)
}