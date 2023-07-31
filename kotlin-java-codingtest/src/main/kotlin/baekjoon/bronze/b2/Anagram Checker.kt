package baekjoon.bronze.b2

fun main()=if(readln().replace(" ", "").toCharArray().sorted()==readln().replace(" ", "").toCharArray().sorted()) println("Is an anagram.") else println("Is not an anagram.")
