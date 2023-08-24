package com.javaexplorer.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "passport")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "passport_id")
    private Long id;

    @Column(name = "passport_no",nullable = false,length = 100)
    private String passportNo;
}
