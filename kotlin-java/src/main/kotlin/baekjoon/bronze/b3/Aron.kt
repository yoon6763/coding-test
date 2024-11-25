package baekjoon.bronze.b3

/*
Aron 실패다국어

시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	32 MB	511	404	377	84.529%
문제
The holiday season is near! Aron wants to get gifts for his friends in Zagreb, so in order to get them on time, he visited a famous toy store in London. After picking out the gifts, he went to the register and discovered that there were already N people in line. Luckily, he noticed that there were groups of people standing in line, in addition to individual customers. A group of people consists of a customer and their friends waiting for them to complete the purchase. The moment when the customer is done, they and their friends leave the line. The people considered a group are standing one behind the other and are wearing shirts of matching colour. Two adjacent groups, adjacent individuals or adjacent individual and a group, will never be wearing shirts of the same colour.

Write a program that will, given the data on the people standing in line, output which person in line Aron is.

입력
The first line of input contains the positive integer N (1 ≤ N ≤ 25) from the task.

Each of the following N lines contains a single character, an uppercase letter of the English alphabet that represents the shirt colour of the i th person in line.

출력
You must output the required number from the task.
 */

fun main() = print(List(readln().toInt()) { readln() }.zipWithNext().count { it.first != it.second } + 2)
