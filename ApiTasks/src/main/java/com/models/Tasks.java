package com.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@JsonPropertyOrder({"id", "task", "completed", "date_task"})
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
@Data
public class Tasks implements Serializable {

    private static final long serialVersionUID = 1254191434652058949L;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("task")
    private String task;

    @JsonProperty("completed")
    private boolean isCompleted;    

    @JsonProperty("date_task")
    private LocalDate dateTask;
    

}
