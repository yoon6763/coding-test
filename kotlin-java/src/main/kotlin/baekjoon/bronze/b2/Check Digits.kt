package baekjoon.bronze.b2

/*
Many items, from books to groceries, from bank accounts to credit cards and practically everything in between are identified primarily by a number, often involving many digits. As you can imagine, it is very easy to make a mistake when transcribing such numbers, thus most such numbers incorporate a mechanism to detect, and possibly correct, errors.

The simplest and easiest scheme calculates a single check digit by multiplying the rightmost digit by 2, the next digit by 3 and so on and then forming the sum. This sum is then divided by 11 and the remainder is subtracted from 11. If this is a number in the range 1 to 9 then it is appended to the right end of the number. If it is equal to 11, the digit 0 is appended as the check digit, and if it is equal to 10, then the original number is rejected.

To check whether a complete number is correct, multiply successive digits, from the right, by 1, 2, 3, etc. and form the sum. If this sum is divisible by 11 then the number is good otherwise it is bad.

As an example, consider the number 2763. To generate the check digit, multiply 3 by 2 (6), multiply 6 by 3 (18), and add (24), multiply 7 by 4 (28) and add (52) and multiply 2 by 5 (10) and add (62). Divide 62 by 11 to give a remainder of 7. Subtract 7 from 11 to give the check digit 4. Thus the full number would be 27634. I will leave you to check that this works the other way and that changing any digit (or even reversing two digits) will cause the number to be wrong.

Write a program that will read in a series of numbers (up to 15 digits long) and then generate check digits for them.

입력
Input will be a series of numbers, one per line. Each number will contain at least one and no more than 15 decimal digits without embedded whitespace. The file will be terminated by a line containing a #.

출력
Output will be a series of lines, one for each number in the input, except for the terminating #. Each line will consist of the original number followed by the characters ‘ -> ’ followed by either the check digit or the word ‘Rejected’.

예제 입력 1
2763
2
6434791100
6434791122
#
예제 출력 1
2763 -> 4
2 -> 7
6434791100 -> 9
6434791122 -> Rejected
 */

fun main() {
    while (true) {
        val input = readln().apply { if (this == "#") return }

        var n = input.toLong()
        var sum = 0L
        var mul = 2

        while (n > 0) {
            sum += (mul++ * (n % 10))
            n /= 10
        }

        sum %= 11
        val ans = when (val r = 11 - sum) {
            10L -> "Rejected"
            11L -> "0"
            else -> r.toString()
        }

        println(if (ans == "Rejected") "$input -> Rejected" else "$input -> $ans")
    }
}