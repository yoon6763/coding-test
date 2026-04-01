package baekjoon.bronze.b4

fun main() {
    val (h, m) = readln().split(" ").map { it.toInt() }
    val t = h * 60 + m

    val ans =
        t in 390..540 || t in 590..600 || t in 650..660 || t in 710..720 || t in 770..830 || t in 880..890 || t in 940..950 || t in 1000..1370

    println(if (ans) "Yes" else "No")
}