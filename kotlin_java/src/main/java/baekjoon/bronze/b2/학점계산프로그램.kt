package baekjoon.bronze.b2

fun main() {
    val grade = readln()

    //A+	4.5
    //A	4.0
    //B+	3.5
    //B	3.0
    //C+	2.5
    //C	2.0
    //D+	1.5
    //D	1.0
    //F	0.0

    var sum = 0.0
    var index = 0
    var cnt = 0
    while (index < grade.length) {
        var ch = grade[index].toString()

        if(index < grade.length - 1 && grade[index + 1] == '+') {
            ch += '+'
            index++
        }

        when(ch) {
            "A+" -> sum += 4.5
            "A" -> sum += 4.0
            "B+" -> sum += 3.5
            "B" -> sum += 3.0
            "C+" -> sum += 2.5
            "C" -> sum += 2.0
            "D+" -> sum += 1.5
            "D" -> sum += 1.0
            "F" -> sum += 0.0
        }

        index++
        cnt++
    }

    println(sum / cnt)
}