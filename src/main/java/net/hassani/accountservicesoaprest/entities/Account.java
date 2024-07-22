package net.hassani.accountservicesoaprest.entities;

import lombok.*;
import net.hassani.accountservicesoaprest.enums.AccountStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    private double balance;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private AccountStatus status;
}
