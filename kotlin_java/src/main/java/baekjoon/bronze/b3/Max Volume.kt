package baekjoon.bronze.b3

fun main() {
    val pi = 3.14159
    val n = readln().toInt()

    var maxVolume = 0.0

    repeat(n) {
        val input = readln().split(" ")

        when (input[0]) {
            "C" -> {
                val r = input[1].toDouble()
                val h = input[2].toDouble()
                val v = (1.0 / 3.0) * pi * r * r * h
                maxVolume = maxOf(maxVolume, v)
            }
            "L" -> {
                val r = input[1].toDouble()
                val h = input[2].toDouble()
                val v = pi * r * r * h
                maxVolume = maxOf(maxVolume, v)
            }
            "S" -> {
                val r = input[1].toDouble()
                val v = (4.0 / 3.0) * pi * r * r * r
                maxVolume = maxOf(maxVolume, v)
            }
        }
    }

    println("%.3f".format(maxVolume))
}