package readmegenerator.platform.data

import org.example.readmegenerator.data.Problem

data class BaekjoonProblem(
    override val title: String,
    override val language: String,
    val tier: String,
    val level: Int
) : Problem(title, language)