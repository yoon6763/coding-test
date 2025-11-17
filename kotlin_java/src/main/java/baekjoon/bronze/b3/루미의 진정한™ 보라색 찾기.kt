package baekjoon.bronze.b3

fun main() {
    val read = { readln().split(" ").map { it.toDouble() } }
    val (hl, hh) = read()
    val (sl, sh) = read()
    val (vl, vh) = read()
    val (r, g, b) = read()

    val V = maxOf(r, g, b)
    val m = minOf(r, g, b)

    println(
        "Lumi will ${
            if ((when (V) {
                    r -> 60.0 * (g - b) / (V - m)
                    g -> 120.0 + 60.0 * (b - r) / (V - m)
                    else -> 240.0 + 60.0 * (r - g) / (V - m)
                } + 360.0) % 360.0 in hl..hh && 255.0 * (V - m) / V in sl..sh && V in vl..vh
            ) "" else "not "
        }like it."
    )
}
