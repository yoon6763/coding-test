package org.example.readmegenerator.data

data class CodeUpProblem(
    override val title: String,
    override val language: String
) : Problem(title, language)