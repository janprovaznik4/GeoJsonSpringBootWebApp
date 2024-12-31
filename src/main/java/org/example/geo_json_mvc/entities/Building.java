package org.example.geo_json_mvc.entities;

import org.example.geo_json_mvc.dto.MappableFormPojo;
import org.example.geo_json_mvc.enums.*;

public class Building implements Mappable {

    private String name;
    private BuildingType type;

    public Building(MappableFormPojo mappableForm) {
        name = mappableForm.getName();
        type = mappableForm.getBuildingType();
    }

    public Building(String name, BuildingType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return name + " (" + type+ ")";
    }

    public BuildingType getType() {
        return type;
    }

    @Override
    public Geometry getShape() {
        return Geometry.POINT;
    }

    @Override
    public String getMarker() {
        return switch (type) {
            case GOVERNMENT -> Color.RED + " " + Marker.STAR;
            case PUBLIC -> Color.GREEN + " " + Marker.SQUARE;
            case PRIVATE ->  Color.BLUE + " " + Marker.PIN;
        };
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(BuildingType type) {
        this.type = type;
    }
}
