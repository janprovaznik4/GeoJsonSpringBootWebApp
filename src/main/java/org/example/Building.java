package org.example;

enum BuildingType {GOVERNMENT, PUBLIC, PRIVATE;}

public class Building implements Mappable {

    private String name;
    private BuildingType type;
    //add usage ->decision for marker

    public Building(String name, BuildingType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getLabel() {
        return name + " (" + type+ ")";
    }

    @Override
    public Geometry getGeometryType() {
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
}
