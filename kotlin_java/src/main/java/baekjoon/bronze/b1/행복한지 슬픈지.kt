package baekjoon.bronze.b1

fun main() {
    val line = readln()
    var happy = 0
    var sad = 0

    for (i in 0 until line.length - 2) {
        if (line[i] == ':' && line[i + 1] == '-') {
            if (line[i + 2] == ')') happy++
            else if (line[i + 2] == '(') sad++
        }
    }

    if (happy == 0 && sad == 0) println("none")
    else if (happy == sad) println("unsure")
    else if (happy > sad) println("happy")
    else println("sad")
}