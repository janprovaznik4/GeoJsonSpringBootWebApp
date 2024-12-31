package org.example.geo_json_mvc.entities;

import org.example.geo_json_mvc.dto.MappableFormPojo;
import org.example.geo_json_mvc.enums.Color;
import org.example.geo_json_mvc.enums.Geometry;
import org.example.geo_json_mvc.enums.Marker;
import org.example.geo_json_mvc.enums.UtilityType;

public class UtilityLine implements Mappable {

    private String name;
    private UtilityType type;

    public UtilityLine(MappableFormPojo mappableForm) {
        name = mappableForm.getName();
        type = mappableForm.getUtilityType();
    }

    public UtilityLine(String name, UtilityType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return name + " (" + type+ ")";
    }

    public UtilityType getType() {
        return type;
    }

    @Override
    public Geometry getShape() {
        return Geometry.LINE;
    }

    @Override
    public String getMarker() {
        return switch (type) {
            case CABLING -> Color.YELLOW + " " + Marker.DOTTED;
            case WATER_PIPELINE -> Color.BLUE + " " + Marker.SOLID;
            case GAS_PIPELINE -> Color.ORANGE + " " + Marker.DOTTED;
            case VENTILATION -> Color.GREEN + " " + Marker.SOLID;
        };
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(UtilityType type) {
        this.type = type;
    }
}
