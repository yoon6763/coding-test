package readmegenerator.platform

import java.io.File

interface Platform {
    val platformName: String

    fun problemAdd(file: File): Boolean
    fun isValidate(path: String): Boolean
    fun generateReadmeContent(): String
    fun getProblemInfoList(): List<ProblemInfo>
    fun sortProblemList()
}