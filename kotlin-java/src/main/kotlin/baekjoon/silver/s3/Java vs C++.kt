package baekjoon.silver.s3

fun main() {
    var line = readln()

    val javaAlphabet = Array(26) { ('A' + it).toString() }
    val cppAlphabet = Array(26) { "_" + ('a' + it).toString() }

    if (line[0].isUpperCase() || line[0] == '_' || line.last() == '_' || line.contains("__") || line.contains('_') && line != line.lowercase()) line = "Error!"
    else if (line != line.lowercase()) for (i in 0 until 26) line = line.replace(javaAlphabet[i], cppAlphabet[i])
    else for (i in 0 until 26) line = line.replace(cppAlphabet[i], javaAlphabet[i])

    if (line[0] == '_') line = line.replaceFirst("_", "")

    println(line)
}