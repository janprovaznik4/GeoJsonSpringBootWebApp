package org.example.geo_json_mvc.controller;

import org.example.geo_json_mvc.dto.MappableFormPojo;
import org.example.geo_json_mvc.entities.Building;
import org.example.geo_json_mvc.entities.UtilityLine;
import org.example.geo_json_mvc.service.InMemoryMappablesStorage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GeoJsonMvcController {

    @Value("${mappables}")
    private List<String> mappableTypes;
    private InMemoryMappablesStorage entities;


    public GeoJsonMvcController(InMemoryMappablesStorage entities) {
        this.entities = entities;
    }

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("entities", entities.getMappables());
        return "mappables/list-mappables";
    }

    @GetMapping("/chooseMappable")
    public String chooseMappable(Model model) {
        model.addAttribute("mappableTypes", mappableTypes);
        return "mappables/choose-type-form";
    }

    @GetMapping("/update")
    public String updateMappable(@RequestParam("index") int index, Model model) {
        model.addAttribute("mappableTypes", mappableTypes);
        model.addAttribute("index", index);
//        if(entities.getMappableById(index) instanceof Building) {
//            model.addAttribute("concreteMappable", (Building) entities.getMappableById(index));
//        } else if (entities.getMappableById(index) instanceof UtilityLine) {
//            model.addAttribute("concreteMappable", (UtilityLine) entities.getMappableById(index));
//        }
        model.addAttribute("mappableTypeString", entities.getMappableById(index).getClass().getSimpleName());
        return "mappables/choose-type-form";
    }

    @GetMapping("/showForm")
    public String showForm(@RequestParam("mappableType") String mappableType, Model model) {
        model.addAttribute("form", new MappableFormPojo(mappableType));
        return "mappables/mappable-form";
    }

    @GetMapping("/updateMappableForm")
    public String showFormForUpdate(@RequestParam("mappableType") String mappableType, @RequestParam("index") int index, Model model) {
        MappableFormPojo mappableForUpdate = new MappableFormPojo(mappableType);
        mappableForUpdate.setConcreteMappable(entities.getMappableById(index), index);
        //regex removing the type part of the name like " (GOVERNMENT)"
        mappableForUpdate.setName(entities.getMappableById(index).getName().replaceAll("\\s*\\(.*\\)$", ""));
        model.addAttribute("form", mappableForUpdate);
        return "mappables/mappable-form";
    }

    @PostMapping("/save")
    public String saveMappable(@ModelAttribute("form") MappableFormPojo mappableForm) {
        if ("Building".equals(mappableForm.getType())) {
            if (mappableForm.getIndex() == -1) {
                entities.getMappables().add(new Building(mappableForm));
            } else {
                entities.getMappables().set(mappableForm.getIndex(), new Building(mappableForm));
            }
        } else if ("UtilityLine".equals(mappableForm.getType())) {
            if (mappableForm.getIndex() == -1) {
                entities.getMappables().add(new UtilityLine(mappableForm));
            } else {
                entities.getMappables().set(mappableForm.getIndex(), new UtilityLine(mappableForm));
            }
        } else {
            throw new IllegalArgumentException("Unknown mappable type: " + mappableForm.getType());
        }
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteMappable(@RequestParam("index") int index) {
        entities.deleteMappableById(index);
        return "redirect:/";
    }

}
