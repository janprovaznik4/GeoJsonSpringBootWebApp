package org.example.geo_json_mvc.dto;

import org.example.geo_json_mvc.entities.Building;
import org.example.geo_json_mvc.entities.Mappable;
import org.example.geo_json_mvc.entities.UtilityLine;
import org.example.geo_json_mvc.enums.BuildingType;
import org.example.geo_json_mvc.enums.UtilityType;

public class MappableFormPojo {
    private String type;
    private String name;
    private BuildingType buildingType;
    private UtilityType utilityType;
    private Building building;
    private UtilityLine utilityLine;
    private int index = -1;

    public MappableFormPojo(String type) {
        this.type = type;
    }

    public void setConcreteMappable(Mappable mappable, int index) {
        this.index = index;
        if(mappable instanceof Building) {
            building = (Building) mappable;
            buildingType = building.getType();
        } else if (mappable instanceof UtilityLine) {
            utilityLine = (UtilityLine) mappable;
            utilityType = utilityLine.getType();
        }
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

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public UtilityLine getUtilityLine() {
        return utilityLine;
    }

    public void setUtilityLine(UtilityLine utilityLine) {
        this.utilityLine = utilityLine;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "MappableFormPojo{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", buildingType=" + buildingType +
                ", utilityType=" + utilityType +
                ", building=" + building +
                ", utilityLine=" + utilityLine +
                ", index=" + index +
                '}';
    }
}
