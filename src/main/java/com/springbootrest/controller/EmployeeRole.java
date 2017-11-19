package com.springbootrest.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"name",
"roleId"
})
public class EmployeeRole {

@JsonProperty("name")
private String name;
@JsonProperty("roleId")
private Integer roleId;
@JsonProperty("id")
private Integer id;


@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("id")
public int getId() {
return id;
}

@JsonProperty("id")
public void setId(int id) {
this.id = id;
}

@JsonProperty("roleId")
public Integer getRoleId() {
return roleId;
}

@JsonProperty("roleId")
public void setRoleId(Integer roleId) {
this.roleId = roleId;
}

}