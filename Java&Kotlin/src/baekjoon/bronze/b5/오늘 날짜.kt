package baekjoon.bronze.b5

import java.text.SimpleDateFormat
import java.util.Calendar

fun main() {
    print(SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().timeInMillis))
}