package domain;

import java.time.LocalDate;

public class AdmHierarchy {
    private String objectId;
    private String parentObjectId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String isActive;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getParentObjectId() {
        return parentObjectId;
    }

    public void setParentObjectId(String parentObjectId) {
        this.parentObjectId = parentObjectId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = LocalDate.parse(startDate);
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = LocalDate.parse(endDate);
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive.equals("1");
    }

    @Override
    public String toString() {
        return "AdmHierarchy{" +
                "objectId='" + objectId + '\'' +
                ", parentObjectId='" + parentObjectId + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isActive='" + isActive + '\'' +
                '}';
    }
}
