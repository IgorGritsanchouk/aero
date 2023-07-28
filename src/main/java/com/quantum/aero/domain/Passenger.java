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
@Table(name = "PASSENGERS",
        uniqueConstraints = @UniqueConstraint(
                name = "uniquePassportNumber",
                columnNames = "PASSPORT_NUMBER"
        ))
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   //strategy = GenerationType.IDENTITY
    @Column(name = "PASSENGER_ID_PK")
    private Long id;

    private String name;

    private String email;

    @Column(name = "PASSPORT_NUMBER")
 //   @UniqueConstraint
    private String passportNumber;

    @Column(name="date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name="last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

//    @OneToMany(targetEntity= Luggage.class, cascade=CascadeType.ALL)
//    @JoinColumn(name="PASSENGER_ID_FK", referencedColumnName = "PASSENGER_ID_PK")
//    private List<Luggage> passengerLuggageLst;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "passenger")
    private List<Luggage> luggageLst;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "FLIGHT_ID_FK")
//    private Flight flight;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "FLIGHT_ID_PK")
//    private Flight flight;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "PASSENGERS_FLIGHTS",
            joinColumns = @JoinColumn(
                    name = "PASSENGER_ID_FK", referencedColumnName = "PASSENGER_ID_PK"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "FLIGHT_ID_FK", referencedColumnName = "FLIGHT_ID_PK"
            )
    )

    private Set<Flight> flights = new HashSet<>();

}
