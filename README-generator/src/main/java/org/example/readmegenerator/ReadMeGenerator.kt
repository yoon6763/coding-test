package readmegenerator

import readmegenerator.mode.GeneratorModeHelper
import readmegenerator.platform.ProblemInfo
import java.io.BufferedReader
import java.io.File
import java.text.SimpleDateFormat
import java.util.Calendar

class ReadMeGenerator {

    private val platforms = Config.supportPlatformList

    fun generateReadMe() {
        val defaultPath = GeneratorModeHelper.getDefaultPath()
        val readMeFile = File("$defaultPath/README.md")

        val rootDirectory = File(defaultPath)

        rootDirectory.walk().forEach { classifyPlatform(it) }
        platforms.forEach { it.sortProblemList() }

        val readMeContent = generateReadMeContent(readMeFile)

        readMeFile.writeText(readMeContent)
    }


    private fun classifyPlatform(file: File) {
        val path = file.path.split(GeneratorModeHelper.getPathSplitter())

        val platformNameList = platforms.map { it.platformName }
        val platformName = path.find { it in platformNameList } ?: return
        val platform = platforms.find { it.platformName == platformName } ?: return

        platform.addProblem(file.path)
    }

    private fun generateReadMeContent(readMe: File): String {
        val content = StringBuilder()

        val bufferedReader = readMe.bufferedReader()
        stackInitialContent(bufferedReader, content)

        val now = Calendar.getInstance().apply { add(Calendar.HOUR, 9) }

        content
            .appendLine("Last Update : ${SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now.time)} <br>")
            .appendLine()
            .appendLine()
            .appendLine("```")

        stackEachLanguageSize(content)

        platforms.forEach { platform -> content.append(platform.generateReadmeContent()) }

        content
            .appendLine()
            .appendLine("```")

        return content.toString()
    }

    private fun stackEachLanguageSize(content: StringBuilder) {
        val problemList = mutableListOf<ProblemInfo>()
        platforms.forEach { problemList.addAll(it.getProblemInfoList()) }

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

}