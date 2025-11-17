package baekjoon.bronze.b5

fun main() {
    repeat(readln().toInt()) {
        println(
            when (readln()) {
                "Algorithm" -> 204
                "DataAnalysis" -> 207
                "ArtificialIntelligence" -> 302
                "CyberSecurity" -> "B101"
                "Network" -> 303
                "Startup" -> 501
                "TestStrategy" -> 105
                else -> 0
            }
        )
    }
}