package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    val dna = readln()

    val table = mapOf(
        'A' to mapOf('A' to 'A', 'G' to 'C', 'C' to 'A', 'T' to 'G'),
        'G' to mapOf('A' to 'C', 'G' to 'G', 'C' to 'T', 'T' to 'A'),
        'C' to mapOf('A' to 'A', 'G' to 'T', 'C' to 'C', 'T' to 'G'),
        'T' to mapOf('A' to 'G', 'G' to 'A', 'C' to 'G', 'T' to 'T')
    )

    println((n - 2 downTo 0).fold(dna[n - 1]) { acc, i -> table[dna[i]]!![acc]!! })
}
