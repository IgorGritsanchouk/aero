package com.quantum.aero.domain;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "FLIGHTS")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   //strategy = GenerationType.IDENTITY
    @Column(name = "FLIGHT_ID_PK")
    private Long id;

    private String departure;

    private String destination;

    @Column(name="date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name="last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "flight")
//    private List<Passenger> passengerLst;
    // one to many unidirectional mapping
    // default fetch type for OneToMany: LAZY
//    @OneToMany(targetEntity= Passenger.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "FLIGHT_ID_FK", referencedColumnName = "FLIGHT_ID_PK")
//    private List<Passenger> passengerLst;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER,
            mappedBy = "flights")
    private Set<Passenger> users = new HashSet<>();

}
//@OneToMany(targetEntity= Luggage.class, cascade=CascadeType.ALL)
//    @JoinColumn(name="PASSENGER_ID_FK", referencedColumnName = "PASSENGER_ID_PK")