package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    var cnt = 0

    for (taekhui in 1..<n) {
        for (yeonghun in 1..<n) {
            for (namgyu in 1..<n) {
                if (taekhui + yeonghun + namgyu > n) break
                if (taekhui + yeonghun + namgyu == n && namgyu >= yeonghun + 2 && taekhui % 2 != 1) {
                    cnt++
                }
            }
        }
    }

    println(cnt)
}