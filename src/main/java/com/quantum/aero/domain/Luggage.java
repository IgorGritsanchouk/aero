package com.quantum.aero.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;

@EqualsAndHashCode
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "LUGGAGE")
public class Luggage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   //strategy = GenerationType.IDENTITY
    @Column(name = "LUGGAGE_ID_PK")
    private Long id;

    private String size;

    @Column(name="date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name="last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

   // private boolean isLateReconcile;

    // default fetch type for ManyToOne: EAGER
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PASSENGER_ID_FK")
    private Passenger passenger;

}
