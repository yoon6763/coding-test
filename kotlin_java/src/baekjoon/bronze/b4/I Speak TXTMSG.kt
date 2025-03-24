package baekjoon.bronze.b4

/*
CU	see you
:-)	I’m happy
:-(	I’m unhappy
;-)	wink
:-P	stick out my tongue
(~.~)	sleepy
TA	totally awesome
CCC	Canadian Computing Competition
CUZ	because
TY	thank-you
YW	you’re welcome
TTYL	talk to you later
 */

fun main() {
    while (true) {
        when (val s = readln()) {
            "CU" -> println("see you")
            ":-)" -> println("I’m happy")
            ":-(" -> println("I’m unhappy")
            ";-)" -> println("wink")
            ":-P" -> println("stick out my tongue")
            "(~.~)" -> println("sleepy")
            "TA" -> println("totally awesome")
            "CCC" -> println("Canadian Computing Competition")
            "CUZ" -> println("because")
            "TY" -> println("thank-you")
            "YW" -> println("you’re welcome")
            "TTYL" -> {
                println("talk to you later")
                break
            }

            else -> println(s)
        }
    }
}