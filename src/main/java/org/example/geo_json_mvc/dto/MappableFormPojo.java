package org.example.geo_json_mvc.dto;

import org.example.geo_json_mvc.enums.BuildingType;
import org.example.geo_json_mvc.enums.UtilityType;

public class MappableFormPojo {
    private String type;
    private String name;
    private BuildingType buildingType;
    private UtilityType utilityType;

    public MappableFormPojo(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public UtilityType getUtilityType() {
        return utilityType;
    }

    public void setUtilityType(UtilityType utilityType) {
        this.utilityType = utilityType;
    }
}
