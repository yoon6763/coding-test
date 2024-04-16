package baekjoon.bronze.b3

fun main() {
    var up = readln().toInt()
    var down = up

    while (true) {
        if (up.toString().endsWith("99")) {
            println(up)
            break
        }

        if (down.toString().endsWith("99")) {
            println(down)
            break
        }

        up++
        down--
    }
}