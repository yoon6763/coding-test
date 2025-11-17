package baekjoon.bronze.b2

fun main() {
    val k = readln().toInt()

    for (i in k downTo 1) {
        when {
            i > 2 -> {
                println("$i bottles of beer on the wall, $i bottles of beer.")
                println("Take one down and pass it around, ${i - 1} bottles of beer on the wall.\n")
            }

            i == 2 -> {
                println("2 bottles of beer on the wall, 2 bottles of beer.")
                println("Take one down and pass it around, 1 bottle of beer on the wall.\n")
            }

            else -> {
                println("1 bottle of beer on the wall, 1 bottle of beer.")
                println("Take one down and pass it around, no more bottles of beer on the wall.\n")
            }
        }
    }

    println("No more bottles of beer on the wall, no more bottles of beer.")
    println(if (k == 1) "Go to the store and buy some more, 1 bottle of beer on the wall." else "Go to the store and buy some more, $k bottles of beer on the wall.")
}
