package baekjoon.bronze.b1

fun main() = with(System.`in`.bufferedReader()) {
    val album = arrayOf(
        Pair(1967, "DavidBowie"),
        Pair(1969, "SpaceOddity"),
        Pair(1970, "TheManWhoSoldTheWorld"),
        Pair(1971, "HunkyDory"),
        Pair(1972, "TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars"),
        Pair(1973, "AladdinSane"),
        Pair(1973, "PinUps"),
        Pair(1974, "DiamondDogs"),
        Pair(1975, "YoungAmericans"),
        Pair(1976, "StationToStation"),
        Pair(1977, "Low"),
        Pair(1977, "Heroes"),
        Pair(1979, "Lodger"),
        Pair(1980, "ScaryMonstersAndSuperCreeps"),
        Pair(1983, "LetsDance"),
        Pair(1984, "Tonight"),
        Pair(1987, "NeverLetMeDown"),
        Pair(1993, "BlackTieWhiteNoise"),
        Pair(1995, "1.Outside"),
        Pair(1997, "Earthling"),
        Pair(1999, "Hours"),
        Pair(2002, "Heathen"),
        Pair(2003, "Reality"),
        Pair(2013, "TheNextDay"),
        Pair(2016, "BlackStar"),
    )

    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val (s, e) = readLine().split(" ").map { it.toInt() }
        val result = album.filter { it.first in s..e }
        sb.append("${result.size}\n")
        result.forEach { sb.append("${it.first} ${it.second}\n") }
    }

    print(sb)
}