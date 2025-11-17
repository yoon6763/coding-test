package baekjoon.bronze.b1

fun main() = repeat(3) {
    val parse = { h: Int, m: Int, s: Int -> h * 3600 + m * 60 + s }
    val (start, end) = readln().split(" ")
    val (sh, sm, ss) = start.split(":").map { it.toInt() }
    val (eh, em, es) = end.split(":").map { it.toInt() }

    var sp = parse(sh, sm, ss)
    var ep = parse(eh, em, es)
    if (sp > ep) ep += 24 * 3600
    println((sp..ep).count { (it / 3600 * 10000 + (it % 3600) / 60 * 100 + it % 60) % 3 == 0 })
}