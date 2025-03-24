package programmers.lv0.영어가_싫어요

fun solution(numbers: String): Long {
    var answer: Long = 0
    var numbers = numbers

    while (numbers != "") {
        answer *= 10

        val num = arrayOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

        for (i in num.indices) {
            if (numbers.startsWith(num[i])) {
                answer += i
                numbers = numbers.substring(num[i].length)
                break
            }
        }
    }

    return answer
}