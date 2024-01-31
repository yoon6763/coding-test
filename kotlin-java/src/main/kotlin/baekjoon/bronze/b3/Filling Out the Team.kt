package baekjoon.bronze.b3

fun main() {
    while (true) {
        val (speed, weight, strength) = readln().split(" ").map { it.toDouble() }
        if (speed == 0.0 && weight == 0.0 && strength == 0.0) break

        val position = mutableListOf<String>()
        if(speed <= 4.5 && weight >= 150 && strength >= 200) position.add("Wide Receiver")
        if(speed <= 6.0 && weight >= 300 && strength >= 500) position.add("Lineman")
        if(speed <= 5.0 && weight >= 200 && strength >= 300) position.add("Quarterback")

        if(position.isEmpty()) position.add("No positions")

        println(position.joinToString(" "))
    }
}