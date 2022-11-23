import org.jsoup.Jsoup

fun main() {
    println("백준 문제 크롤링 중 ... ")
    val url = "https://www.acmicpc.net/user/yoon6763"
    val conn = Jsoup.connect(url)
    val html = conn.get()

    // 맞은 문제, 시도했지만 맞지 못한 문제, 맞은 번외 문제
    val classTag = html.getElementsByClass("problem-list")

    val problemsTags = classTag[0].getElementsByTag("a")
    val bjProblems = problemsTags.map { it.text().toInt() }
    println("백준 문제 크롤링 완료\n")

    println("티스토리 탐색중 ...")

    val blogProblems = ArrayList<Int>()

    for (i in 1..100) {
        try {
            println("티스토리 탐색 - $i")
            val tistoryUrl = "https://uknowblog.tistory.com/$i"
            val tistoryConn = Jsoup.connect(tistoryUrl)
            val tistoryHtml = tistoryConn.get()

            val title = tistoryHtml.title()
            if (title.startsWith("[백준 ")) {
                val problem = title.split("]")[0].filter { it.isDigit() }.toInt()
                blogProblems.add(problem)
            }
        } catch (e: Exception) {
            println("오류페이지 => $i")
        }
    }

    println("\n\n포스팅하지 않은 문제")
    bjProblems.forEach {
        if (it !in blogProblems) {
            println(it)
        }
    }
    println("총 풀은 문제 : ${bjProblems.size}\t총 포스팅한 문제 : ${blogProblems.size}\t포스팅하지 않은 문제 : ${bjProblems.size - blogProblems.size}")
}