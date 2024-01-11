package com.exam.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BOOKINGS")
@EqualsAndHashCode(callSuper = true)
public class BookingEntity extends AppEntity {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "bookingIdSeq", sequenceName = "BOOKING_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookingIdSeq")
    private Long id;

    @Column(name = "VALID_UNTIL", nullable = false)
    private Instant validUntil;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal bookingPrice;

    @ManyToOne
    @JoinColumn(name = "ROOM_ID", nullable = false)
    private RoomEntity room;

}
