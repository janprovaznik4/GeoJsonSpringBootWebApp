package org.example;

public class Main {
    public static void main(String[] args) {
        // Create instances of Building
        Building governmentBuilding = new Building("City Hall", BuildingType.GOVERNMENT);
        Building publicLibrary = new Building("Public Library", BuildingType.PUBLIC);
        Building privateOffice = new Building("Tech Startup Office", BuildingType.PRIVATE);

        // Print properties of Building instances
        Mappable.printProperties(governmentBuilding);
        Mappable.printProperties(publicLibrary);
        Mappable.printProperties(privateOffice);

        // Create instances of UtilityLine
        UtilityLine cablingLine = new UtilityLine("Fiber Optic Cable", UtilityType.CABLING);
        UtilityLine waterPipeline = new UtilityLine("Main Water Pipeline", UtilityType.WATER_PIPELINE);
        UtilityLine gasPipeline = new UtilityLine("Natural Gas Pipeline", UtilityType.GAS_PIPELINE);
        UtilityLine ventilationShaft = new UtilityLine("Building Ventilation", UtilityType.VENTILATION);

        // Print properties of UtilityLine instances
        Mappable.printProperties(cablingLine);
        Mappable.printProperties(waterPipeline);
        Mappable.printProperties(gasPipeline);
        Mappable.printProperties(ventilationShaft);
    }
}