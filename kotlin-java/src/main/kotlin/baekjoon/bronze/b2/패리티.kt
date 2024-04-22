package baekjoon.bronze.b2

fun main() {
    while (true) {
        val line = readln()
        if (line == "#") break
        val lineCharArray = line.toCharArray()
        val countOfOne = line.count { it == '1' }

        if (countOfOne % 2 == 0) {
            if (lineCharArray.last() == 'e') lineCharArray[lineCharArray.size - 1] = '0'
            else lineCharArray[lineCharArray.size - 1] = '1'
        } else {
            if (lineCharArray.last() == 'e') lineCharArray[lineCharArray.size - 1] = '1'
            else lineCharArray[lineCharArray.size - 1] = '0'
        }

        println(lineCharArray.joinToString(""))
    }
}