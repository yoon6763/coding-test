package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()

    repeat(n) {
        readln()
        val tokens = readln().split(" ")

        var sum = 0
        var many = false

        for (i in tokens.indices step 2) {
            val t = tokens[i]
            if (t == "!") {
                many = true
                break
            }
            sum += t.toInt()
        }

        if (many || sum > 9) println("!")
        else println(sum)
    }
}