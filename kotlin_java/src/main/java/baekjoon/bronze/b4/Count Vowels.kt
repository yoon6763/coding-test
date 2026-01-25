package baekjoon.bronze.b4

fun main() {
    val vowels = setOf('a', 'e', 'i', 'o', 'u')

    repeat(readln().toInt()) {
        val word = readln()
        var count = 0

        for (ch in word) {
            if (ch in vowels) count++
        }

        println("The number of vowels in $word is $count.")
    }
}
