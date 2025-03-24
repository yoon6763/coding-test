package baekjoon.bronze.b1

fun main() {
    val (type, str) = readln().split(" ")
    val std = ArrayList<String>()

    if (type == "2") {
        std.addAll(str.split("_"))
    } else {
        val cur = ArrayList<Char>()
        for (c in str) {
            if (c.isUpperCase()) {
                std.add(cur.joinToString("").lowercase())
                cur.clear()
            }
            cur.add(c)
        }
        std.add(cur.joinToString("").lowercase())
    }
    std.removeIf { it.isEmpty() }

    println(std.mapIndexed { index, s -> if (index == 0) s else s.capitalize() }.joinToString(""))
    println(std.joinToString("_"))
    println(std.joinToString("") { it.capitalize() })
}