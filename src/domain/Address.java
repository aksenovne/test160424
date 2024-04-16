package domain;

import java.time.LocalDate;

public class Address {
    private String objectId;
    private String name;
    private String typeName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String isActual;
    private String isActive;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public String getIsActual() {
        return isActual;
    }

    public void setIsActual(String isActual) {
        this.isActual = isActual;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public boolean isActiveAndActual() {
        return isActive.equals("1") && isActual.equals("1");
    }

    @Override
    public String toString() {
        return "Address{" +
                "objectId='" + objectId + '\'' +
                ", name='" + name + '\'' +
                ", typeName='" + typeName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", isActual='" + isActual + '\'' +
                ", isActive='" + isActive + '\'' +
                '}';
    }
}
