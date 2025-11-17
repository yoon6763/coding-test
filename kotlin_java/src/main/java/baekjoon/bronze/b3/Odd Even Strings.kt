package baekjoon.bronze.b3

fun main() {
    val map = HashMap<Char, Int>()
    readln().forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }

    var evenCount = 0
    var oddCount = 0
    for ((_, count) in map) if (count % 2 == 0) evenCount++ else oddCount++

    println(
        when {
            oddCount == 0 -> "0"
            evenCount == 0 -> "1"
            else -> "0/1"
        }
    )
}
