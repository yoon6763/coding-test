package readmegenerator.platform

import org.example.readmegenerator.data.CodeUpProblem
import readmegenerator.Config
import readmegenerator.mode.GeneratorModeHelper
import readmegenerator.platform.data.BaekjoonProblem
import java.io.File

class CodeUp : Platform {
    override val platformName: String = "codeup"

    private val supportLanguage = Config.supportLanguage
    private val problems = mutableListOf<CodeUpProblem>()

    override fun addProblem(path: String) {
        val splitPath = separatePath(path)

        val fileName = splitPath.last()
        val title = fileName.split(".").first()
        val extension = fileName.split(".").last()
        val language = supportLanguage[extension] ?: return

        problems.add(CodeUpProblem(title, language))
    }

    override fun generateReadmeContent(): String {
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