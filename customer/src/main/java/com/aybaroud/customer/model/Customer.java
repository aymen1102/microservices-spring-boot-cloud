package com.aybaroud.customer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/*
@Data generate code :
    - getters @Getter
    - setters @Setter
    - equals and hashcode @EqualsAndHashCode
    - toString @ToString
 */
@Data
/*
@Builder allow to create instance of this object easily
       Customer.builder()
                .id(..)
                .firstName(..)
                ...
                .build();
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName= "customer_id_sequence"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_sequence")
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}
