package io.jenkins.plugins;

import java.io.Serializable;

public class Build implements Serializable {
    private String buildUrl;

    public Build(String buildUrl) {
        this.buildUrl = buildUrl;
    }

    public String getBuildUrl() {
        return buildUrl;
    }

    public void setBuildUrl(String buildUrl) {
        this.buildUrl = buildUrl;
    }
}
