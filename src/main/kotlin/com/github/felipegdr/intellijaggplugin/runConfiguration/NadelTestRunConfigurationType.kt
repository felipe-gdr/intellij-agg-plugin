package com.github.felipegdr.intellijaggplugin.runConfiguration

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.icons.AllIcons
import javax.swing.Icon

class NadelTestRunConfigurationType : ConfigurationType {
    override fun getDisplayName(): String {
        return "Nadel test"
    }

    override fun getConfigurationTypeDescription(): String {
        return "Nadel test run configuration type"
    }

    override fun getIcon(): Icon {
        return AllIcons.General.Information
    }

    override fun getId(): String {
        return ID
    }

    override fun getConfigurationFactories(): Array<ConfigurationFactory> {
        return arrayOf(NadelTestConfigurationFactory(this))
    }

    companion object {
        const val ID = "NadelTestRunConfiguration"
    }
}