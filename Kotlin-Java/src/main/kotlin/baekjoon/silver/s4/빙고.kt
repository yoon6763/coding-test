package baekjoon.silver.s4

fun main() {
    var arr = Array(5) { Array(5) { 0 } }
    var arrAnswer = Array(5) { Array(5) { 0 } }

    for (i in 0..4) {
        val line = readLine()!!.split(" ")
        for (k in 0..4) {
            arr[i][k] = line[k].toInt()
        }
    }
    for (i in 0..4) {
        val line = readLine()!!.split(" ")
        for (k in 0..4) {
            arrAnswer[i][k] = line[k].toInt()
        }
    }
    var cnt = 0
    for (i in 0..4) {
        for (j in 0..4) {
            cnt++
            for (k in 0..4) {
                val idx = arr[k].indexOf(arrAnswer[i][j])
                if (idx != -1) {
                    arr[k][idx] = 0
                    break
                }
            }

            if (match(arr)) {
                print(cnt)
                return
            }
        }
    }
}

//2차원 배열 매개변수... 실화냐고
fun match(arr: Array<Array<Int>>): Boolean {
    var cnt = 0
    var match = 0
    for (i in 0..4) {
        for (j in 0..4) {
            if (arr[i][j] == 0) {
                cnt++
            }
        }
        if (cnt == 5) {
            match++
        }
        cnt = 0
    }

    for (i in 0..4) {
        for (j in 0..4) {
            if (arr[j][i] == 0) {
                cnt++
            }
        }
        if (cnt == 5) {
            match++
        }
        cnt = 0
    }

    for (i in 0..4) {
        if (arr[i][i] == 0) {
            cnt++
        }
    }
    if (cnt == 5) {
        match++
    }
    cnt = 0


    for (i in 0..4) {
        if (arr[i][4 - i] == 0) {
            cnt++
        }
    }
    if (cnt == 5) {
        match++
    } else {
        cnt = 0
    }

    return match >= 3
}