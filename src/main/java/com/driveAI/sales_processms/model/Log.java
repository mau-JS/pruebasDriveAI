package com.driveai.sales_processms.model;

import com.driveai.sales_processms.others.JSONObjectConverter;
import jakarta.persistence.*;
import org.json.simple.JSONObject;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String str_table_name;

    private String str_action;
    @Convert(converter = JSONObjectConverter.class)
    private JSONObject json_old_data;

    @Convert(converter = JSONObjectConverter.class)
    private JSONObject json_new_data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStr_table_name() {
        return str_table_name;
    }

    public void setStr_table_name(String str_table_name) {
        this.str_table_name = str_table_name;
    }

    public String getStr_action() {
        return str_action;
    }

    public void setStr_action(String str_action) {
        this.str_action = str_action;
    }

    public JSONObject getJson_old_data() {
        return json_old_data;
    }

    public void setJson_old_data(JSONObject json_old_data) {
        this.json_old_data = json_old_data;
    }

    public JSONObject getJson_new_data() {
        return json_new_data;
    }

    public void setJson_new_data(JSONObject json_new_data) {
        this.json_new_data = json_new_data;
    }
}
