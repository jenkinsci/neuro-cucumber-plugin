package io.jenkins.plugins;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import hudson.FilePath;
import hudson.model.AbstractBuild;
import hudson.model.Action;
import org.apache.commons.io.IOUtils;
import org.kohsuke.stapler.export.Exported;
import org.kohsuke.stapler.export.ExportedBean;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@ExportedBean
public class TestAction implements Action, Serializable {
    private static final long serialVersionUID = 1L;
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private List<Map<String, Object>> testResult;
    private final String path;
    private final transient AbstractBuild<?, ?> build;

    public TestAction(AbstractBuild<?, ?> build, String path) throws IOException, InterruptedException {
        this.path = path;
        this.build = build;
        getTestResults();
    }


    @Exported(visibility=2)
    public List<Map<String, Object>> getTestResult() {
        return testResult == null ? new ArrayList<>() : testResult;
    }

    public void setTestResult(List<Map<String, Object>> testResult) {
        this.testResult = testResult;
    }

    @Override
    public String getIconFileName() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return "TestReport";
    }

    @Override
    public String getUrlName() {
        return "testReport";
    }

    @SuppressFBWarnings(value = "NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE")
    private void getTestResults() throws IOException, InterruptedException {
        FilePath filePath = new FilePath(Objects.requireNonNull( build.getWorkspace()), path);
        InputStream is = filePath.read();
        String text = IOUtils.toString(is, StandardCharsets.UTF_8.name()).replaceAll("[\\x00-\\x09\\x11\\x12\\x14-\\x1F\\x7F]", "");
        testResult =  parse(text, List.class);
    }

    static private <T> T parse(String content, Class<T> clazz) throws IOException {
            return MAPPER.readValue(content, clazz);
    }
}
