package baekjoon.bronze.b4

fun main() {
    val mobis = BooleanArray(5)
    readln().forEach {
        when(it) {
            'M' -> mobis[0] = true
            'O' -> mobis[1] = true
            'B' -> mobis[2] = true
            'I' -> mobis[3] = true
            'S' -> mobis[4] = true
        }
    }
    println(if(mobis.all { it }) "YES" else "NO")
}