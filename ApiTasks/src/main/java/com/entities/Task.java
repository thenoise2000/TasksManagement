package com.entities;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "task")
@ToString
@EqualsAndHashCode
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class Task implements Serializable {

    private static final long serialVersionUID = -3661292867055495781L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task", nullable = false, length = 200)
    private String task;

    @Column(name = "completed", nullable = false)
    private boolean completed;    

    @Column(name = "date_task", nullable = false)
    private LocalDate dateTask;    

}