package readmegenerator

import readmegenerator.platform.ProblemInfo
import java.io.BufferedReader
import java.io.File

val platformList = Config.supportPlatformList

fun main() {
    val javaKotlinPath = System.getProperty("user.dir")
    val defaultPath = File(javaKotlinPath).parent

    searchSolvedProblems(defaultPath)
    updateReadMe(defaultPath)
}

fun updateReadMe(defaultPath: String) {
    val readMe = File("$defaultPath/README.md")
    val content = StringBuilder()

    val bufferedReader = readMe.bufferedReader()
    stackInitialContent(bufferedReader, content)

    content.appendLine()
    content.appendLine()
    content.appendLine("```")

    stackEachLanguageSize(content)

    platformList.forEach { platform -> content.append(platform.generateReadmeContent()) }

    content.appendLine()
    content.appendLine("```")

    println(content.toString())
    readMe.writeText(content.toString())
}

private fun stackEachLanguageSize(content: StringBuilder) {
    val problemList = mutableListOf<ProblemInfo>()
    platformList.forEach { problemList.addAll(it.getProblemInfoList()) }

    content.appendLine("${problemList.size} Solved")

    problemList.groupBy { it.language }.toList().sortedBy { -it.second.size }.forEach {
        content.appendLine(" - ${it.first} : ${it.second.size}")
    }

    content.appendLine()
    content.appendLine()
}

private fun stackInitialContent(bufferedReader: BufferedReader, content: StringBuilder) {
    while (true) {
        val line = bufferedReader.readLine() ?: break
        content.appendLine(line)
        if (line.contains("## Solved Problems")) break
    }
}

private fun searchSolvedProblems(path: String) {
    val baseFolder = File(path)

    baseFolder.list()?.forEach { path ->

        val file = File("${baseFolder.path}/$path")
        if (file.isFile) {
            for (platform in platformList) {
                if (platform.problemAdd(file)) break
            }
            return@forEach
        }

        searchSolvedProblems("${baseFolder.path}/$path")
    }
}
