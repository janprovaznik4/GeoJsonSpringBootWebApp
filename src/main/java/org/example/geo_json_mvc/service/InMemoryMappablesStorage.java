package org.example.geo_json_mvc.service;

import org.example.geo_json_mvc.entities.Building;
import org.example.geo_json_mvc.entities.Mappable;
import org.example.geo_json_mvc.entities.UtilityLine;
import org.example.geo_json_mvc.enums.BuildingType;
import org.example.geo_json_mvc.enums.UtilityType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryMappablesStorage {

    private List<Mappable> mappables;

    public InMemoryMappablesStorage() {
        mappables = new ArrayList<>();
//        addMappable(new Building("City Hall", BuildingType.GOVERNMENT));
//        addMappable(new Building("Public Library", BuildingType.PUBLIC));
//        addMappable(new Building("Tech Startup Office", BuildingType.PRIVATE));
//        addMappable(new UtilityLine("Fiber Optic Cable", UtilityType.CABLING));
//        addMappable(new UtilityLine("Main Water Pipeline", UtilityType.WATER_PIPELINE));
//        addMappable(new UtilityLine("Natural Gas Pipeline", UtilityType.GAS_PIPELINE));
//        addMappable(new UtilityLine("Building Ventilation", UtilityType.VENTILATION));
    }

    public List<Mappable> getMappables() {
        return mappables;
    }

    public Mappable getMappableById(int id) {
        return mappables.get(id);
    }

    public void addMappable(Mappable newMappable) {
        mappables.add(newMappable);
    }

    public Mappable deleteMappableById(int id) {
        return mappables.remove(id);
    }
}