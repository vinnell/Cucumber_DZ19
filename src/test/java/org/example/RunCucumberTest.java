package org.example;

import io.cucumber.core.options.Constants;
import org.junit.platform.suite.api.*;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("scenarios")
@ConfigurationParameters({
        @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "definitions"),
        @ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@run")
})

public class RunCucumberTest {
}
