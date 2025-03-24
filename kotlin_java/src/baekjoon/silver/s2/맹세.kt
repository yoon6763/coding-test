package baekjoon.silver.s2

import java.util.LinkedList
import java.util.Queue

fun main() = with(System.`in`.bufferedReader()) {
    val table = arrayOf(
        "h",
        "b",
        "c",
        "n",
        "o",
        "f",
        "p",
        "s",
        "k",
        "v",
        "y",
        "i",
        "w",
        "u",
        "ba",
        "ca",
        "ga",
        "la",
        "na",
        "pa",
        "ra",
        "ta",
        "db",
        "nb",
        "pb",
        "rb",
        "sb",
        "tb",
        "yb",
        "ac",
        "sc",
        "tc",
        "cd",
        "gd",
        "md",
        "nd",
        "pd",
        "be",
        "ce",
        "fe",
        "ge",
        "he",
        "ne",
        "re",
        "se",
        "te",
        "xe",
        "cf",
        "hf",
        "rf",
        "ag",
        "hg",
        "mg",
        "rg",
        "sg",
        "bh",
        "rh",
        "th",
        "bi",
        "li",
        "ni",
        "si",
        "ti",
        "bk",
        "al",
        "cl",
        "fl",
        "tl",
        "am",
        "cm",
        "fm",
        "pm",
        "sm",
        "tm",
        "cn",
        "in",
        "mn",
        "rn",
        "sn",
        "zn",
        "co",
        "ho",
        "mo",
        "no",
        "po",
        "np",
        "ar",
        "br",
        "cr",
        "er",
        "fr",
        "ir",
        "kr",
        "lr",
        "pr",
        "sr",
        "zr",
        "as",
        "cs",
        "ds",
        "es",
        "hs",
        "os",
        "at",
        "mt",
        "pt",
        "au",
        "cu",
        "eu",
        "lu",
        "pu",
        "ru",
        "lv",
        "dy"
    )

    next@ for (i in 0..<readLine().toInt()) {
        val target = readLine()
        val visited = BooleanArray(target.length + 1)
        val q = LinkedList<Int>() as Queue<Int>
        q.add(0)
        visited[0] = true

        while (q.isNotEmpty()) {
            val curIndex = q.poll()

            if (curIndex == target.length) {
                println("YES")
                continue@next
            }

            table.forEach { e ->
                if (e.length == 1 &&
                    e[0] == target[curIndex] &&
                    !visited[curIndex + 1]
                ) {
                    visited[curIndex + 1] = true
                    q.add(curIndex + 1)
                }

                if (e.length == 2 && curIndex + 1 < target.length &&
                    e[0] == target[curIndex] && e[1] == target[curIndex + 1]
                    && !visited[curIndex + 2]
                ) {
                    visited[curIndex + 2] = true
                    q.add(curIndex + 2)
                }
            }
        }

        println("NO")
    }
}