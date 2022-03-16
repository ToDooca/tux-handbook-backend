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
public class PC extends Auditable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "pc_id")
    private Long id;
    private String os;
    private String kernel;
    private String cpu;
    private int ram;
    @ManyToOne
    @JoinColumn(name = "user_fk", referencedColumnName = "user_id")
    private User user;
}
