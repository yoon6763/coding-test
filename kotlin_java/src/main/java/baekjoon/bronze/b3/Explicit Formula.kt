package baekjoon.bronze.b3

fun main() {
    val b = readln().split(" ").map { it.toInt() != 0 }.toBooleanArray()

    var res = false

    for (i in 0 until 10) {
        for (j in i + 1 until 10) {
            res = res xor (b[i] || b[j])
            for (k in j + 1 until 10) {
                res = res xor (b[i] || b[j] || b[k])
            }
        }
    }

    println(if (res) 1 else 0)
}
