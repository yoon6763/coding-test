package readmegenerator

import org.example.readmegenerator.mode.GenerateMode
import readmegenerator.platform.Baekjoon
import readmegenerator.platform.GroomthonChallenge
import readmegenerator.platform.Platform
import readmegenerator.platform.Programmers

object Config {

    val generatorMode = GenerateMode.GITHUB_ACTIONS

    val supportLanguage = hashMapOf(
        "a68" to "algol68",
        "c" to "C",
        "cpp" to "C++",
        "java" to "Java",
        "kt" to "Kotlin",
        "f95" to "Fortran",
        "bas" to "FreeBASIC",
        "gs" to "GolfScript",
        "js" to "JavaScript",
        "py" to "Python",
        "rb" to "Ruby",
        "sql" to "SQL",
        "vb" to "Visual Basic",
    )

    val supportPlatformList = listOf<Platform>(
        Baekjoon(),
        Programmers(),
        GroomthonChallenge(),
    )
}