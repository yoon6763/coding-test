package baekjoon.bronze.b2

fun main() {
    val lowerWords = listOf('r', 'o', 'y', 'g', 'b', 'i', 'v')
    val upperWords = listOf('R', 'O', 'Y', 'G', 'B', 'I', 'V')
    readln()
    val line = readln().toCharArray()
    val upper = HashSet<Char>()
    val lower = HashSet<Char>()

    line.forEach {
        if (it in upperWords) upper.add(it)
        else if (it in lowerWords) lower.add(it)
    }

    println(when {
        upper.size == 7 && lower.size == 7 -> "YeS"
        upper.size == 7 -> "YES"
        lower.size == 7 -> "yes"
        else -> "NO!"
    })
}