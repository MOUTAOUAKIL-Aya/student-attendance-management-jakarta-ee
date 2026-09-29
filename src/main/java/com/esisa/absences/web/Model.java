package com.esisa.absences.web;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

public class Model {
    private Hashtable<String, Object> models;
    public Model() { models = new Hashtable<String, Object>(); }
    public void add(String name, Object model) { models.put(name, model); }
    public Object get(String name) { return models.get(name); }
    public List<String> getAllModelsNames() { return new Vector<String>(models.keySet()); }
}
