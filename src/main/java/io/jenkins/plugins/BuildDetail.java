package io.jenkins.plugins;

import java.util.ArrayList;
import java.util.List;

public class BuildDetail {
    private Integer number;
    private String id;
    private Long duration;
    private Long estimatedDuration;
    private String displayName;
    private String fullDisplayName;
    private String result;
    private Long timestamp;
    private String url;
    private List<TestAction> actions;
    private String projectName;

    public BuildDetail withNumber(Integer number) {
        this.setNumber(number);
        return this;
    }

    public BuildDetail withId(String id) {
        this.setId(id);
        return this;
    }

    public BuildDetail withDuration(Long duration) {
        this.setDuration(duration);
        return this;
    }

    public BuildDetail withEstimatedDuration(Long estimatedDuration) {
        this.setEstimatedDuration(estimatedDuration);
        return this;
    }

    public BuildDetail withDisplayName(String displayName) {
        this.setDisplayName(displayName);
        this.setFullDisplayName(projectName + " " + displayName);
        return this;
    }

    public BuildDetail withResult(String result) {
        this.setResult(result);
        return this;
    }

    public BuildDetail withTimeStamp(Long timeStamp) {
        this.setTimestamp(timeStamp);
        return this;
    }

    public BuildDetail withUrl(String url) {
        this.setUrl(url);
        return this;
    }

    public BuildDetail withActions(List<TestAction> actions) {
        this.setActions(actions == null ? new ArrayList<>() : actions);
        return this;
    }

    public BuildDetail withProjectName(String projectName) {
        this.setProjectName(projectName);
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(Long estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFullDisplayName() {
        return fullDisplayName;
    }

    public void setFullDisplayName(String fullDisplayName) {
        this.fullDisplayName = fullDisplayName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<TestAction> getActions() {
        return actions;
    }

    public void setActions(List<TestAction> actions) {
        this.actions = actions;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
