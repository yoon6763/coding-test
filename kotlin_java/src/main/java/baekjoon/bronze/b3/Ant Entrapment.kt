package baekjoon.bronze.b3

fun main() {
    for (i in 1..readln().toInt()) {
        val n = readln().toInt()

        val ants = List(n) {
            val (x, y) = readln().split(" ").map { it.toDouble() }
            x to y
        }

        val w = ants.maxOf { it.first } - ants.minOf { it.first }
        val h = ants.maxOf { it.second } - ants.minOf { it.second }

        println("Case $i: Area ${w * h}, Perimeter ${2 * (w + h)}")
    }
}
