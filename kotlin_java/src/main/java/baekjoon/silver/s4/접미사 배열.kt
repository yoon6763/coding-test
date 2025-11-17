package baekjoon.silver.s4

fun main() {
    val origin = readln()

    val strArray = ArrayList<String>()

    for (i in origin.indices) {
        strArray.add(origin.substring(i, origin.length))
    }

    strArray.sort()

    val sb = StringBuilder()

    strArray.forEach { sb.append(it).append("\n") }
    print(sb)
}