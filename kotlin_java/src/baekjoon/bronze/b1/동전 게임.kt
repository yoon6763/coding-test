package baekjoon.bronze.b1

fun main() = repeat(readln().toInt()) {
    val coin = readln()
    val coinList = IntArray(8) { 0 }

    for (j in 0..<coin.length - 2) {
        when (coin.substring(j, j + 3)) {
            "TTT" -> coinList[0]++
            "TTH" -> coinList[1]++
            "THT" -> coinList[2]++
            "THH" -> coinList[3]++
            "HTT" -> coinList[4]++
            "HTH" -> coinList[5]++
            "HHT" -> coinList[6]++
            "HHH" -> coinList[7]++
        }
    }

    println(coinList.joinToString(" "))
}