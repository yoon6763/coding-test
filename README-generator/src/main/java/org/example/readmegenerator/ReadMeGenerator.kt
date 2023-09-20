package readmegenerator

import readmegenerator.mode.GeneratorModeHelper
import readmegenerator.platform.ProblemInfo
import java.io.BufferedReader
import java.io.File
import java.text.SimpleDateFormat
import java.util.Calendar
import kotlin.collections.ArrayList

class ReadMeGenerator {

    val platformList = Config.supportPlatformList

    fun generate() {
        val defaultPath = GeneratorModeHelper.getDefaultPath()

        searchSolvedProblems(defaultPath)
        updateReadMe(defaultPath)
    }

    fun updateReadMe(defaultPath: String) {
        val readMe = File("$defaultPath/README.md")
        val content = StringBuilder()

        val bufferedReader = readMe.bufferedReader()
        stackInitialContent(bufferedReader, content)

        val now = Calendar.getInstance().apply {
            add(Calendar.HOUR, 9)
        }
        SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        content.appendLine("Last Update : ${SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now.time)} <br>")

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
}