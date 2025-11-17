package baekjoon.bronze.b4

fun main() {
    while (true) {
        val weightOnEarth = readln().toDouble()
        if (weightOnEarth < 0) break
        val weightOnMoon = weightOnEarth * 0.167
        println("Objects weighing %.2f on Earth will weigh %.2f on the moon.".format(weightOnEarth, weightOnMoon))
    }
}
