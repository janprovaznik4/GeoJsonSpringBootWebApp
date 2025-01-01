package org.example.geo_json_mvc.entities;

import org.example.geo_json_mvc.enums.Geometry;

public interface Mappable {

    String JSON_PROPERTY = """
            "properties": {%s}
            """;
    String getName();
    Geometry getShape();
    String getMarker();

    default String toJSON() {
        return """
                "type": "%s", "label": "%s", "marker": "%s"
                """.formatted(getShape(), getName(), getMarker());
    }

    static String printProperties(Mappable mappable) {
        String printResult = JSON_PROPERTY.formatted(mappable.toJSON());
        System.out.println(printResult);
        return printResult;
    }
}
