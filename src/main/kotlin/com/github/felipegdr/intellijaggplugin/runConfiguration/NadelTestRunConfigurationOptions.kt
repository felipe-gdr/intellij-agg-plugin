package com.github.felipegdr.intellijaggplugin.runConfiguration

import com.intellij.execution.configurations.RunConfigurationOptions

class NadelTestRunConfigurationOptions : RunConfigurationOptions() {
    private val testNameProp = string("").provideDelegate(this, "testName")
    var testName: String?
        get() = testNameProp.getValue(this)
        set(testName) {
            testNameProp.setValue(this, testName)
        }
}