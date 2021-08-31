package com.github.felipegdr.intellijaggplugin.runConfiguration

import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.ui.LabeledComponent
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import javax.swing.JComponent
import javax.swing.JPanel

class NadelTestSettingsEditor: SettingsEditor<NadelTestRunConfiguration>() {
    private var myPanel: JPanel? = null
    private var myScriptName: LabeledComponent<TextFieldWithBrowseButton>? = null

    override fun resetEditorFrom(nadelTestRunConfiguration: NadelTestRunConfiguration) {
        myScriptName?.component?.setText(nadelTestRunConfiguration.testName)
    }

    override fun applyEditorTo(nadelTestRunConfiguration: NadelTestRunConfiguration) {
        nadelTestRunConfiguration.testName = myScriptName?.component?.text
    }

    override fun createEditor(): JComponent {
        return myPanel!!
    }

    private fun createUIComponents() {
        myScriptName = LabeledComponent()
        myScriptName?.component = TextFieldWithBrowseButton()
    }
}