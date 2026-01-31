package baekjoon.bronze.b1

fun main() {
    for (i in 1..readln().toInt()) {
        val count = IntArray(26)
        readln().forEach { ch -> if (ch.isLetter()) count[ch.lowercase()[0] - 'a']++ }
        println(
            "Case $i: ${
                when (count.min()) {
                    0 -> "Not a pangram"
                    1 -> "Pangram!"
                    2 -> "Double pangram!!"
                    else -> "Triple pangram!!!"
                }
            }"
        )
    }
}