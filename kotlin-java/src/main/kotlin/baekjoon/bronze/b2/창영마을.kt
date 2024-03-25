package baekjoon.bronze.b2

fun main() {
    val pos = BooleanArray(3)
    pos[0] = true

    readln().forEach {
        when(it) {
            'A' -> {
                val temp = pos[0]
                pos[0] = pos[1]
                pos[1] = temp
            }
            'B' -> {
                val temp = pos[1]
                pos[1] = pos[2]
                pos[2] = temp
            }
            'C' -> {
                val temp = pos[0]
                pos[0] = pos[2]
                pos[2] = temp
            }
        }
    }

    println(pos.indexOf(true) + 1)
}