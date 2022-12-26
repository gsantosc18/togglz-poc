package com.example.togglzpoc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.Feature;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.util.NamedFeature;

@RestController
public class TogglzController {
    private final FeatureManager manager;

    public static final Feature MY_FLAG = new NamedFeature("MY_FLAG");

    public TogglzController(FeatureManager manager) {
        this.manager = manager;
    }

    @RequestMapping("/")
    public String index() {
        if (manager.isActive(MY_FLAG)) {
            return "Flag ativada";
        }
        return "Inativa";
    }
}
