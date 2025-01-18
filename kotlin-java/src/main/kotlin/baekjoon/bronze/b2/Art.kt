package baekjoon.bronze.b2

fun main() {
    val lengths = readln().split(" ").map { it.toInt() }.sorted()
    var triangleCount = 0

    for (i in 0..<3) {
        for (j in i + 1..<4) {
            for (k in j + 1..<5) {
                if (lengths[i] + lengths[j] > lengths[k]) {
                    triangleCount++
                }
            }
        }
    }

    println(triangleCount)
}
