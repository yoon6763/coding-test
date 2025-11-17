package baekjoon.silver.s5

fun main() {
    val count = arrayOf(3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1)
    val a = readln()
    val b = readln()

    var list = mutableListOf<Int>()
    for (i in a.indices) {
        list.add(count[a[i] - 'A'])
        list.add(count[b[i] - 'A'])
    }

    while (list.size > 2) {
        val temp = mutableListOf<Int>()
        for (i in 0..<list.size - 1) temp.add((list[i] + list[i + 1]) % 10)
        list = temp
    }

    println("${list[0]}${list[1]}")
}