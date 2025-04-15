package baekjoon.bronze.b2

fun main() {
    val buckets = Array(3) { readln().split(" ").map { it.toInt() }.toMutableList() }

    repeat(100) { i ->
        val from = i % 3
        val to = (i + 1) % 3
        val fromMilk = buckets[from][1]
        val toMilk = buckets[to][1]
        val toCapacity = buckets[to][0]
        val pour = minOf(toCapacity - toMilk, fromMilk)

        buckets[from][1] -= pour
        buckets[to][1] += pour
    }

    buckets.forEach { println(it[1]) }
}