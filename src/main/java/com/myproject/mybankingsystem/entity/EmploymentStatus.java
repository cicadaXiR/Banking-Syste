package com.myproject.mybankingsystem.entity;

public enum EmploymentStatus {
    FULLTIME("full-time"),
    PARTTIME("part-time"),
    SELFEMPLOYED("self-employed");

    private final String jobStatus;

    EmploymentStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobStatus() {
        return jobStatus;
    }
}

