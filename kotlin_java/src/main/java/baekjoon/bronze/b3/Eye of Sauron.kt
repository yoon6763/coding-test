package baekjoon.bronze.b3

fun main() {
    val s = readln()
    val eyeIndex = s.indexOf("()")
    println(if (s.substring(0, eyeIndex).count { it == '|' } == s.substring(eyeIndex + 2)
            .count { it == '|' }) "correct" else "fix")
}
