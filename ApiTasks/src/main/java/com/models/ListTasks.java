package com.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@FieldNameConstants
@Setter
@Getter
public class ListTasks implements Serializable {

    @JsonProperty("tasks")
    private List<Tasks> listTasks;
}
