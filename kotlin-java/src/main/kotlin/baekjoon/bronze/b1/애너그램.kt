package baekjoon.bronze.b1

fun main() {
    val num = readLine()!!.toInt()

    for (i in 0 until num) {
        var line = readLine()!!.split(" ")

        var arr1 = line[0].uppercase().toCharArray().sorted().joinToString("")
        var arr2 = line[1].uppercase().toCharArray().sorted().joinToString("")

        if(arr1 != arr2) {
            println("${line[0]} & ${line[1]} are NOT anagrams.")
        }  else {
            println("${line[0]} & ${line[1]} are anagrams.")
        }
    }
}