package readmegenerator.platform

import readmegenerator.Config
import readmegenerator.mode.GeneratorModeHelper
import readmegenerator.platform.data.BaekjoonProblem
import java.io.File

class Baekjoon : Platform {

    /*
      baekjoon
      - gold
          - g1
              - problem1.kt
              - problem2.kt
          - g2
              - problem3.kt

      - silver
          - s1
              - problem4.kt
          - s2
              - problem5.kt
              - problem6.kt
   */

    override val platformName: String = "baekjoon"

    private val supportLanguage = Config.supportLanguage
    private val problems = mutableListOf<BaekjoonProblem>()
    private val tierList = listOf("diamond", "platinum", "gold", "silver", "bronze", "unrated")

    override fun addProblem(path: String) {
        val splitPath = separatePath(path)

        val fileName = splitPath.last()

        val title = fileName.split(".").first()
        val extension = fileName.split(".").last()
        val language = supportLanguage[extension] ?: return

        val level = splitPath[splitPath.indexOf(platformName) + 2][1].digitToInt()
        val tier = splitPath[splitPath.indexOf(platformName) + 1]

        problems.add(BaekjoonProblem(title, language, tier, level))
    }

    override fun generateReadmeContent(): String {
        val sb = StringBuilder()
        sb.appendLine(platformName)

        problems.groupBy { it.tier }.forEach { (tier, problems) ->
            sb.appendLine("  $tier")
            problems.groupBy { it.level }.forEach { (level, problems) ->
                sb.appendLine("    ${tier[0]}$level")
                problems.forEach { problem ->
                    sb.appendLine("      [${problem.language}] ${problem.title.replace("_", " ")}")
                }
            }
            sb.appendLine()
        }

        return sb.toString()
    }

    override fun sortProblemList() {
        val languageCount = HashMap<String, Int>()
        val tierPriority = Array(tierList.size) { Pair(tierList[it], it) }.toMap()

        problems.forEach {
            languageCount[it.language] = languageCount.getOrDefault(it.language, 0) + 1
        }

        problems.sortWith(compareBy(
            { tierPriority[it.tier] },
            { it.level },
            { -languageCount[it.language]!! },
            { it.title }
        ))
    }

    override fun getProblemInfoList(): List<ProblemInfo> {
        return problems.map { ProblemInfo(it.title, platformName, it.language) }
    }
}