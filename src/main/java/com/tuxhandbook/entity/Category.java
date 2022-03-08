package com.tuxhandbook.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;


@Table
@Entity
@Getter @Setter @NoArgsConstructor @ToString
public class Category extends Auditable{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "category_id")
    private Long id;
    private String name;
}
