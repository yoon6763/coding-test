package baekjoon.bronze.b2

fun main() {
    val t = readln()
    val key = t[0].code xor 'C'.code
    println(t.map { (it.code xor key).toChar() }.joinToString(""))
}
