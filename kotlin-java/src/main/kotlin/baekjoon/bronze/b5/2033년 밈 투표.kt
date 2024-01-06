package baekjoon.bronze.b5

fun main() {
    val N = readln().toInt()

    repeat(N) {
        val name = readln()

        if (name !in listOf(
                "Never gonna give you up",
                "Never gonna let you down",
                "Never gonna run around and desert you",
                "Never gonna make you cry",
                "Never gonna say goodbye",
                "Never gonna tell a lie and hurt you",
                "Never gonna stop"
            )
        ) {
            println("Yes")
            return
        }
    }

    println("No")
}
