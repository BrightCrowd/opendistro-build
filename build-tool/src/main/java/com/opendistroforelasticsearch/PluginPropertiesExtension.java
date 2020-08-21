package com.opendistroforelasticsearch;

import org.gradle.api.Project;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * A container for plugin properties that will be written to the plugin descriptor, for easy
 * manipulation in the gradle DSL.
 */
public class PluginPropertiesExtension {
    private String name;

    private String version;

    private String description;

    private String classname;

    /** Other plugins this plugin extends through SPI like JS plugin **/
    private List<String> extendedPlugins = new ArrayList<>();

    private boolean hasNativeController;

    /** True if the plugin requires the elasticsearch keystore to exist, false otherwise. */
    private boolean requiresKeystore;

    /** A license file that should be included in the built plugin zip. */
    private File licenseFile;

    /**
     * A notice file that should be included in the built plugin zip. This will be
     * extended with notices from the {@code licenses/} directory.
     */
    private File noticeFile;

    private final Project project;

    public PluginPropertiesExtension(Project project) {
        this.project = project;
    }

    public String getName() {
        return name == null ? project.getName() : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version == null ? project.getVersion().toString() : version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public List<String> getExtendedPlugins() {
        return this.extendedPlugins;
    }

    public boolean isHasNativeController() {
        return hasNativeController;
    }

    public void setHasNativeController(boolean hasNativeController) {
        this.hasNativeController = hasNativeController;
    }

    public boolean isRequiresKeystore() {
        return requiresKeystore;
    }

    public void setRequiresKeystore(boolean requiresKeystore) {
        this.requiresKeystore = requiresKeystore;
    }

    public File getLicenseFile() {
        return licenseFile;
    }

    public void setLicenseFile(File licenseFile) {
        this.project.getExtensions().getExtraProperties().set("licenseFile", licenseFile);
        this.licenseFile = licenseFile;
    }

    public File getNoticeFile() {
        return noticeFile;
    }

    public void setNoticeFile(File noticeFile) {
        this.project.getExtensions().getExtraProperties().set("noticeFile", noticeFile);
        this.noticeFile = noticeFile;
    }

    public Project getProject() {
        return project;
    }

    public void setExtendedPlugins(List<String> extendedPlugins) {
        this.extendedPlugins = extendedPlugins;
    }
}

