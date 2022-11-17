package ru.ezuykow.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ezuykow.app.models.Item;
import ru.ezuykow.app.services.BucketService;

import java.util.Collection;

@RestController
@RequestMapping("/order")
public class BucketController {

    private final BucketService bucketService;

    @Autowired
    public BucketController(BucketService bucketService) {
        this.bucketService = bucketService;
    }

    @GetMapping("/get")
    public Collection<Item> getItems() {
        return bucketService.getItems();
    }

    @GetMapping("/add")
    public void addItem(@RequestParam(name = "item", required = false) int[] ids) {
        bucketService.addItems(ids);
    }
}
