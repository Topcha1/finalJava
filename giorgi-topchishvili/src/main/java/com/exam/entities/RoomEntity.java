package com.exam.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@SuperBuilder
@Table(name = "ROOMS")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RoomEntity extends AppEntity {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "roomIdSeq", sequenceName = "ROOM_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomIdSeq")
    private Long id;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @Column(name = "IS_OCCUPIED", nullable = false)
    private Boolean isOccupied;

    @ManyToOne
    @JoinColumn(name = "HOTEL_ID", nullable = false)
    private HotelEntity hotel;

    @OneToMany
    private List<BookingEntity> bookings;

}
