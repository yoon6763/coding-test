package baekjoon.bronze.b2

fun main() {
    while (true) {
        var n = readln().let { if (it == "0") return else it }
        print("$n ")

        if (n.length != 1) {
            while (true) {
                var temp = 1
                for (i in n) temp *= i.toString().toInt()
                print("$temp ")
                n = temp.toString()
                if (n.length == 1) break
            }
        }
        println()
    }
}
