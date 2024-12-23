package org.example;

enum Geometry {POINT, LINE, POLYGON}
enum Marker {STAR, PIN, SQUARE, DOTTED, SOLID}
enum Color {RED, ORANGE, YELLOW, GREEN, BLUE, PURPLE}

interface Mappable {

    String JSON_PROPERTY = """
            "properties": {%s}
            """;
    String getLabel();
    Geometry getGeometryType();
    String getMarker();

    default String toJSON() {
        return """
                "type": "%s", "label": "%s", "marker": "%s"
                """.formatted(getGeometryType(), getLabel(), getMarker());
    }

    static void printProperties(Mappable mappable) {
        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
    }
}
