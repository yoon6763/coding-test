package baekjoon.silver.s4

fun main() {
    val hash = HashMap<String, Int>()
    val n = readln().toInt()
    repeat(n) {
        val name = readln()
        hash[name] = hash.getOrDefault(name, 0) + 1
    }
    repeat(n - 1) {
        val name = readln()
        hash[name] = hash[name]!! + 1
    }
    println(hash.filter { it.value % 2 == 1 }.keys.first())
}