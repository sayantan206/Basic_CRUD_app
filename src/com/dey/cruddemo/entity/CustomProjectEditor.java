package com.dey.cruddemo.entity;

import java.beans.PropertyEditorSupport;
import java.util.HashSet;
import java.util.Set;

public class CustomProjectEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Set<Project> projectList = new HashSet<>();

        String[] projects = text.split(",");
        for (String projectName : projects)
            projectList.add(new Project(projectName.trim()));

        setValue(projectList);
    }
}