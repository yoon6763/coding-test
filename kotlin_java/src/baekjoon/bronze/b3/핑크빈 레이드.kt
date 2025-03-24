package baekjoon.bronze.b3

fun main() {
    val arr = Array(3) { readln().split(" ").map { it.toInt() } }
    var hp = readln().toInt()
    var time = -1

    while (hp > 0) {
        time++
        arr.forEach { (skillTime, damage) -> if (time % skillTime == 0) hp -= damage }
    }

    println(time)
}
