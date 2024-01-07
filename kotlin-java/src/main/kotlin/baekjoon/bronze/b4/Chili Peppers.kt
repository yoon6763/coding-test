package baekjoon.bronze.b4

fun main() {
    var t = 0
    repeat(readln().toInt()) {
        t += when (readln()) {
            "Poblano" -> 1500
            "Mirasol" -> 6000
            "Serrano" -> 15500
            "Cayenne" -> 40000
            "Thai" -> 75000
            "Habanero" -> 125000
            else -> 0
        }
    }

    println(t)
}