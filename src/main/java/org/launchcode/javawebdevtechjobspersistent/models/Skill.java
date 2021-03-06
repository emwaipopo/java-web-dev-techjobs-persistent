package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

    @NotNull
    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 75, message = "Name must be between 3 and 75 characters")
    private String name;

    @NotBlank(message = "A skill description is required")
    @Size(min = 3, max = 250, message = "Description must be between 3 and 250 characters long")
    private String description;

    @ManyToMany(mappedBy="skills")
    private List<Job> jobs = new ArrayList<Job>();

    public Skill() { }

    public Skill( String description, List<Job> jobs) {
        this.description = description;
        this.jobs = jobs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}