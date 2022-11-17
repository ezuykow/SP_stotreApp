package ru.ezuykow.app.models;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.TreeSet;

@Component
@SessionScope
public class Bucket extends TreeSet<Item> {

}
