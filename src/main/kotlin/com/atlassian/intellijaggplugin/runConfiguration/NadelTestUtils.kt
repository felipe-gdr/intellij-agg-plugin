package com.atlassian.intellijaggplugin.runConfiguration

import com.intellij.psi.PsiElement

fun PsiElement.isInFixtureFile(): Boolean {
    val directory = this.containingFile.containingDirectory

    val isInFixtureDir =
        (directory.name.contains(NadelTestConstants.FIXTURES_DIR_NAME) ||
                directory.parentDirectory?.name?.contains(NadelTestConstants.FIXTURES_DIR_NAME) ?: false)

    return this.isInYamlFile() && isInFixtureDir

}

fun PsiElement.isInYamlFile(): Boolean {
    return this.containingFile.name.endsWith("yml") || this.containingFile.name.endsWith("yaml")
}