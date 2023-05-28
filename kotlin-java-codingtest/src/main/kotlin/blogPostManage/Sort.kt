package blogPostManage

import java.io.File

fun main() {
    val rootPath = System.getProperty("user.dir")
    val postedProblemsFile = File("$rootPath/src/main/java/blogPostManage/PostedProblems.txt")

    val postedProblems = ArrayList<Int>()
    postedProblemsFile.forEachLine {
        postedProblems.add(it.toInt())
    }

    postedProblems.sort()
    
    postedProblemsFile.writeText("") // 파일 내용 제거
    
    postedProblems.forEach {
        postedProblemsFile.appendText("$it\n")
    }
}
