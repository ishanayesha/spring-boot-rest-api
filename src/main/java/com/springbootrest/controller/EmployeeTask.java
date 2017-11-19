package com.springbootrest.controller;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"taskId"
})
public class EmployeeTask {

@JsonProperty("id")
private Integer id;
@JsonProperty("taskId")
private int taskId;

@JsonProperty("id")
public Integer getId() {
return id;
}

@JsonProperty("id")
public void setId(Integer id) {
this.id = id;
}

@JsonProperty("taskId")
public int getTaskId() {
return taskId;
}

@JsonProperty("taskId")
public void setTaskId(int taskId) {
this.taskId = taskId;
}

}