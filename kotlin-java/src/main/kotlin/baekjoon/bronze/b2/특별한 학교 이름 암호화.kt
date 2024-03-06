package baekjoon.bronze.b2

fun main() {
    val target = readln()

    val map = hashMapOf(
        "North London Collegiate School" to "NLCS",
        "Branksome Hall Asia" to "BHA",
        "Korea International School" to "KIS",
        "St. Johnsbury Academy" to "SJA"
    )

    for (school in map.keys) {
        val parsedName = school.filter { it.isLetter() }.lowercase().substring(0, 10)
        for (i in 0..<26) {
            val shift = parsedName.map { ((it.toInt() - 97 + i) % 26 + 97).toChar() }.joinToString("")
            if (shift == target) {
                println(map[school])
                return
            }
        }
    }
}