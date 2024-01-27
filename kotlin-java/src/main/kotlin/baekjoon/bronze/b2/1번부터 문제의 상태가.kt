package baekjoon.bronze.b2

fun main() {
    var s = readln()
    if ('A' in s) {
        val target = arrayOf("B", "C", "D", "F")
        for (t in target) s = s.replace(t.toRegex(), "A")
        println(s)
        return
    }

    if ('B' in s) {
        val target = arrayOf("C", "D", "F")
        for (t in target) s = s.replace(t.toRegex(), "B")
        println(s)
        return
    }

    if ('C' in s) {
        val target = arrayOf("D", "F")
        for (t in target) s = s.replace(t.toRegex(), "C")
        println(s)
        return
    }

    println("A".repeat(s.length))
}