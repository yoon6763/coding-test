package baekjoon.bronze.b3

fun main() {
    var (flour, choco, egg, butter) = readln().split(" ").map { it.toInt() }
    val (needF, needC, needE, needB) = readln().split(" ").map { it.toInt() }

    var ans = 0

    repeat(readln().toInt()) {
        val (type, value) = readln().split(" ").map { it.toInt() }

        when (type) {
            1 -> {
                if (flour >= needF * value &&
                    choco >= needC * value &&
                    egg >= needE * value &&
                    butter >= needB * value
                ) {
                    flour -= needF * value
                    choco -= needC * value
                    egg -= needE * value
                    butter -= needB * value
                    ans += value
                    println(ans)
                } else {
                    println("Hello, siumii")
                }
            }

            2 -> {
                flour += value
                println(flour)
            }

            3 -> {
                choco += value
                println(choco)
            }

            4 -> {
                egg += value
                println(egg)
            }

            5 -> {
                butter += value
                println(butter)
            }
        }
    }
}
