package io.jenkins.plugins;

import static java.lang.String.format;

public class Builder {
    private String buildUrl;
    private String path;
    private Integer buildNumber;
    private String project;

    public Builder(String baseUrl, String path) {
        this.buildUrl = format("%s%s", baseUrl, path);
        this.path = path;
    }
    public Builder withBuildNumber(Integer buildNumber) {
        this.buildNumber = buildNumber;
        return this;
    }

    public Builder withProject(String project) {
        this.project = project;
        return this;
    }

    public Build build() {
        Build build = new Build(buildUrl);
        build.setPath(path);
        build.setBuildNumber(buildNumber);
        build.setProject(project);
        return build;
    }
}
