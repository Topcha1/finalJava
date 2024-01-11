package com.exam.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HOTELS")
@EqualsAndHashCode(callSuper = true)
public class HotelEntity extends AppEntity {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "hotelIdSeq", sequenceName = "HOTEL_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotelIdSeq")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

}


