package io.jenkins.plugins;

import java.io.Serializable;

public class Build implements Serializable {
    private String buildUrl;
    private String path;
    private Integer buildNumber;
    private String project;

    public Build(String buildUrl) {
        this.buildUrl = buildUrl;
    }

    public String getBuildUrl() {
        return buildUrl;
    }

    public void setBuildUrl(String buildUrl) {
        this.buildUrl = buildUrl;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(Integer buildNumber) {
        this.buildNumber = buildNumber;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
