package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while (true) {
        val line = readLine()
        if(line == "EOI") break
        if (line.toLowerCase().contains("nemo")) {
            sb.append("Found\n")
        } else {
            sb.append("Missing\n")
        }
    }

    print(sb)
}