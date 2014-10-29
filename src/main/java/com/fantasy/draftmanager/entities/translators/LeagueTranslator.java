/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.draftmanager.entities.translators;

import com.fantasy.draftmanager.annotations.SerializableProperty;
import com.fantasy.draftmanager.entities.League;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mac
 */
public class LeagueTranslator implements JsonDeserializer<League>, JsonSerializer<League> {

    @Override
    public League deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JsonElement serialize(League l, Type type, JsonSerializationContext jsc) {
        JsonObject jobj = new JsonObject();

        Field[] fields = l.getClass().getDeclaredFields();
        for (Field f : fields) {
            SerializableProperty sp = f.getAnnotation(SerializableProperty.class);
            if (Objects.nonNull(sp)) {
                try {
                    Class<?> fieldType = f.getType();
                    Object val = f.get(l);
                    String name = f.getName();

                    setValue(jobj, name, val);
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(LeagueTranslator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return jobj;
    }

    private void setValue(JsonObject jo, String propName, Object val) {
        if (val instanceof String) {
            jo.addProperty(propName, (String) val);
        } else if (val instanceof Number) {
            jo.addProperty(propName, (Number) val);
        } else if (val instanceof Character) {
            jo.addProperty(propName, (Character) val);
        } else if (val instanceof Boolean) {
            jo.addProperty(propName, (Boolean) val);
        }
    }

}
