package com.atlassian.intellijaggplugin.runConfiguration

import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.LazyRunConfigurationProducer
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement
import org.jetbrains.plugins.gradle.service.execution.GradleRunConfiguration

class NadelTestRunConfigurationProducer : LazyRunConfigurationProducer<GradleRunConfiguration>() {
    override fun getConfigurationFactory(): ConfigurationFactory =
        NadelTestConfigurationFactory(NadelTestRunConfigurationType())

    override fun setupConfigurationFromContext(
        configuration: GradleRunConfiguration,
        context: ConfigurationContext,
        sourceElement: Ref<PsiElement>
    ): Boolean {
        val element = sourceElement.get()

        if (element.isInFixtureFile()) {
            val fileName = element.containingFile.name

            configuration.name = fileName
            configuration.settings.env = mapOf(NadelTestConstants.VAR_NAME_TEST to fileName)
            return true
        }

        return false
    }

    override fun isConfigurationFromContext(
        configuration: GradleRunConfiguration,
        context: ConfigurationContext
    ): Boolean {
        val element = context.psiLocation

        return configuration.name == element?.containingFile?.name
    }
}
