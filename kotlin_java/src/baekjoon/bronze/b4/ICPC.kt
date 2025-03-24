package baekjoon.bronze.b4

fun main() {
    val (p1, e1) = readln().split(" ").map(String::toInt)
    val (e2, p2) = readln().split(" ").map(String::toInt)

    val p = p1 + p2
    val e = e1 + e2
    if (p > e) println("Persepolis")
    else if (p < e) println("Esteghlal")
    else {
        if (e1 > p2) println("Esteghlal")
        else if (e1 < p2) println("Persepolis")
        else println("Penalty")
    }
}