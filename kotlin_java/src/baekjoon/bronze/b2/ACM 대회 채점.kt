package baekjoon.bronze.b2

fun main() {
    val map = mutableMapOf<String, IntArray>()
    var correct = 0
    var total = 0

    while (true) {
        val line = readln()
        if (line == "-1") {
            map.values.forEach { result ->
                if (result[0] != 0) {
                    correct++
                    total += result[0] + result[1] * 20
                }
            }
            break
        }

        val (timeStr, problem, result) = line.split(" ")
        val time = timeStr.toInt()
        val current = map.getOrPut(problem) { IntArray(2) }

        if (result == "right" && current[0] == 0) current[0] = time
        else if (result == "wrong" && current[0] == 0) current[1]++
    }

    println("$correct $total")
}
