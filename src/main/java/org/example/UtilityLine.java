package org.example;

enum UtilityType {CABLING, WATER_PIPELINE, GAS_PIPELINE, VENTILATION;}

public class UtilityLine implements Mappable {

    private String name;
    private UtilityType type;
    //add utility ->decision for marker

    public UtilityLine(String name, UtilityType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getLabel() {
        return name + " (" + type+ ")";
    }

    @Override
    public Geometry getGeometryType() {
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
}
