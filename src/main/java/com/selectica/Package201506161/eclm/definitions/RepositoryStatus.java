package com.selectica.Package201506161.eclm.definitions;

/**
 * Created by vshilkin on 12/01/2015.
 */
public enum RepositoryStatus {
    DRAFT("Draft"),
    ACTIVE("Active"),
    INACTIVE("Inactive");

    private String status;

    RepositoryStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

