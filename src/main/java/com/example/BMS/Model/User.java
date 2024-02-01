package com.example.BMS.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String mobile;

    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Ticket> bookedTickets;
}
