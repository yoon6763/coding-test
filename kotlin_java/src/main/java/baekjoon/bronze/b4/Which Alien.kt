package baekjoon.bronze.b4

fun main() {
    val antenna = readln().toInt()
    val eyes = readln().toInt()

    if (antenna >= 3 && eyes <= 4) {
        println("TroyMartian")
    }
    if (antenna <= 6 && eyes >= 2) {
        println("VladSaturnian")
    }
    if (antenna <= 2 && eyes <= 3) {
        println("GraemeMercurian")
    }
}