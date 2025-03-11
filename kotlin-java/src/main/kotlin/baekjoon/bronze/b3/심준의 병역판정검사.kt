package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val (cm, kg) = readln().split(" ").map { it.toDouble() }
    val bmi = kg / (cm * cm / 10000)

    println(
        when {
            cm < 140.1 -> 6
            cm < 146 -> 5
            cm < 159 -> 4
            cm < 161 -> if (bmi in 16.0..34.9) 3 else 4
            cm < 204 -> when (bmi) {
                in 20.0..24.9 -> 1
                in 18.5..19.9, in 25.0..29.9 -> 2
                in 16.0..18.4, in 30.0..34.9 -> 3
                else -> 4
            }
            else -> 4
        }
    )
}
