package baekjoon.bronze.b2

fun main() {
    val hash = HashMap<Char, Int>()
    readln()
    readln().forEach { hash[it] = hash.getOrDefault(it, 0) + 1 }

    var min = 987654321
    "BONZSILV".forEach { min = minOf(min, hash.getOrDefault(it, 0)) }
    "ER".forEach { min = minOf(min, hash.getOrDefault(it, 0) / 2) }
    print(min)
}