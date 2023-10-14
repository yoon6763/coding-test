package readmegenerator

import org.example.readmegenerator.mode.GenerateMode
import readmegenerator.platform.*

object Config {

    val generatorMode = GenerateMode.GITHUB_ACTIONS

    val supportLanguage = hashMapOf(
        // 확장자 to 언어명
        "a68" to "Algol68",
        "c" to "C",
        "cpp" to "C++",
        "cs" to "C#",
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
        "adb" to "Ada",
    )

    val supportPlatformList = listOf<Platform>(
        Baekjoon(),
        Programmers(),
        GroomthonChallenge(),
        Softeer(),
        CodeUp(),
    )
}