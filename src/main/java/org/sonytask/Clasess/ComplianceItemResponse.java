package org.sonytask.Clasess;

import org.sonytask.Entity.ComplianceItem;

import java.util.List;

public class ComplianceItemResponse {
    private List<ComplianceItem> data;
    private String message;

    public ComplianceItemResponse(List<ComplianceItem> data, String message) {
        this.data = data;
        this.message = message;
    }
    public List<ComplianceItem> getData() {
        return data;
    }

    public void setData(List<ComplianceItem> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
