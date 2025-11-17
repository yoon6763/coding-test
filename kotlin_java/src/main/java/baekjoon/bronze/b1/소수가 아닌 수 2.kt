package baekjoon.bronze.b1

fun main() {
    val k = readln().toDouble()
    var p = 1
    var q = 1

    while (kotlin.math.abs(p.toDouble() / q - k) > 1e-6) {
        if (p.toDouble() / q > k) q += 1 else p += 1
    }

    println("YES\n$p $q")
}
