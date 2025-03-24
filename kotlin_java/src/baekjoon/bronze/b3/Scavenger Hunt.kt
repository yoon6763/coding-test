package baekjoon.bronze.b3

fun main() {
    val (p, q) = readln().split(" ").map { it.toInt() }
    val (plst, qlst) = List(2) { mutableListOf<Int>() }

    (1..maxOf(p, q)).forEach { i ->
        if (p % i == 0) plst.add(i)
        if (q % i == 0) qlst.add(i)
    }

    plst.forEach { p ->
        qlst.forEach { q ->
            println("$p $q")
        }
    }
}
