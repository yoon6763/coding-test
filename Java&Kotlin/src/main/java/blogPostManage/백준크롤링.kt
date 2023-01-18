package blogPostManage

import org.jsoup.Jsoup
import java.io.File

fun main() {
    println("백준 문제 크롤링 중 ... ")
    val url = "https://www.acmicpc.net/user/yoon6763"
    val conn = Jsoup.connect(url)
    val html = conn.get()

    // 맞은 문제, 시도했지만 맞지 못한 문제, 맞은 번외 문제
    val classTag = html.getElementsByClass("problem-list")

    val problemsTags = classTag[0].getElementsByTag("a")
    val solvedProblems = problemsTags.map { it.text().toInt() } // 푼 문제
    val postedProblems = ArrayList<Int>() // 포스팅한 문제
    val notPostedProblems = ArrayList<Int>() // 포스팅 안한 문제


    println("백준 문제 크롤링 완료\n")

    val rootPath = System.getProperty("user.dir")
    val lastFoundFile = File("$rootPath/src/main/java/blogPostManage/LastFoundIdx.txt")
    val postedProblemFile = File("$rootPath/src/main/java/blogPostManage/PostedProblems.txt")
    var idx = lastFoundFile.readText().toInt()
    var lastPostIdx = idx

    postedProblemFile.forEachLine {
        postedProblems.add(it.toInt())
    }

    println("티스토리 탐색중 ...")

    var exceptionCnt = 0

    while (true) {
        if (exceptionCnt > 5) break

        try {
            println("티스토리 탐색 - $idx")
            val tistoryUrl = "https://uknowblog.tistory.com/$idx"
            val tistoryConn = Jsoup.connect(tistoryUrl)
            val tistoryHtml = tistoryConn.get()

            val title = tistoryHtml.title()
            if (title.startsWith("[백준 ")) {
                val problem = title.split("]")[0].filter { it.isDigit() }.toInt()

                if(problem !in postedProblems) {
                    postedProblems.add(problem)
                    postedProblemFile.appendText("$problem\n")
                }
            }

            lastPostIdx = idx
            exceptionCnt = 0

        } catch (e: Exception) {
            println("오류페이지 => $idx")
            exceptionCnt++
        }

        idx++
    }
    lastFoundFile.writeText(lastPostIdx.toString())

    solvedProblems.forEach { problem ->
        if (problem !in postedProblems) {
            notPostedProblems.add(problem)
        }
    }

    println("\n\n포스팅하지 않은 문제")
    notPostedProblems.forEach { println(it) }

    println("\n총 풀은 문제 : ${solvedProblems.size}\t총 포스팅한 문제 : ${postedProblems.size}\t\t 포스팅하지 않은 문제 : ${notPostedProblems.size}")

    val rdProblems = ArrayList<Int>()

    while (rdProblems.size < 7) {
        val rd = notPostedProblems.random()
        if (rd !in rdProblems) {
            rdProblems.add(rd)
        }
    }

    println("\n\n랜덤 7문제")
    rdProblems.forEach {
        println(it)
    }
}