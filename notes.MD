https://plugins.jetbrains.com/docs/intellij/run-configuration-management.html

To run from context
```
<runConfigurationProducer implementation="io.kotest.plugin.intellij.run.SpecRunConfigurationProducer"/>
```

To run from gutter
```
<runLineMarkerContributor language="kotlin" implementationClass="io.kotest.plugin.intellij.run.SpecRunLineMarkerContributor"/>
```