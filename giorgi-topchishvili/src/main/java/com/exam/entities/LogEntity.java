package com.exam.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "LOGS")
public class LogEntity {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "logIdSeq", sequenceName = "LOG_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "logIdSeq")
    private Long id;

    @Column(name = "LOG_CREATION_DATE", updatable = false)
    protected Instant logCreationDate;

    @Column(name = "CLASS_NAME", nullable = false)
    private String className;

    @Column(name = "METHOD_NAME", nullable = false)
    private String methodName;

    @Column(name = "METHOD_EXECUTION_MILLIS", nullable = false)
    private Long methodExecutionMillis;

}


