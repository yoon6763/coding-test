package readmegenerator.platform

import org.example.readmegenerator.data.CodeUpProblem
import readmegenerator.Config
import readmegenerator.mode.GeneratorModeHelper
import readmegenerator.platform.data.BaekjoonProblem
import java.io.File

class CodeUp : Platform {

    val supportLanguage = Config.supportLanguage

    override val platformName: String = "codeup"
    private val problems = mutableListOf<CodeUpProblem>()

    override fun problemAdd(file: File): Boolean {
        val path = file.path
        return isValidate(path)
    }

    override fun isValidate(path: String): Boolean {
        val pathList = path.split(GeneratorModeHelper.getPathSplitter())
        if (platformName !in path) return false

        val extension = pathList.last().split(".").last()
        if (extension !in supportLanguage) return false

        val language = supportLanguage[extension] ?: return false
        val title = pathList.last().split(".").first()

        problems.add(CodeUpProblem(title, language))
        return true
    }

    override fun generateReadmeContent(): String {
        sortProblemList()

        val sb = StringBuilder()
        sb.appendLine(platformName)

        problems.forEach { problem ->
            sb.appendLine("  [${problem.language}] ${problem.title.replace("_", " ")}")
        }

        return sb.toString()
    }

    override fun sortProblemList() {
        val languageCount = mutableMapOf<String, Int>()

        problems.forEach {
            languageCount[it.language] = languageCount.getOrDefault(it.language, 0) + 1
        }

        problems.sortWith(
            compareBy(
                { -languageCount[it.language]!! },
                { it.title }
            )
        )
    }

    override fun getProblemInfoList(): List<ProblemInfo> {
        return problems.map { ProblemInfo(it.title, platformName, it.language) }
    }
}