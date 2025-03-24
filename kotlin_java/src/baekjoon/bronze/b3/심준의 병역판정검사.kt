package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    readln().split(" ").map { it.toDouble() }.let { (cm, kg) ->
        val bmi = kg / (cm * cm / 10000)
        println(
            when {
                cm < 140.1 -> 6
                cm < 146 -> 5
                cm < 159 -> 4
                cm < 161 -> if (bmi >= 16.0 && bmi < 35.0) 3 else 4
                cm < 204 -> when {
                    bmi >= 20.0 && bmi < 25.0 -> 1
                    (bmi >= 18.5 && bmi < 20.0) || (bmi >= 25.0 && bmi < 30.0) -> 2
                    (bmi >= 16.0 && bmi < 18.5) || (bmi >= 30 && bmi < 35.0) -> 3
                    else -> 4
                }

                else -> 4
            }
        )
    }
}
