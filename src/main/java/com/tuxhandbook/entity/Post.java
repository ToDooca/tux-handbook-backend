package com.tuxhandbook.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Table
@Entity
@Getter @Setter @NoArgsConstructor @ToString
public class Post extends Auditable{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "post_id")
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Category category;
    @OneToOne
    private PC pc;
    private String title;
    private String body;
    private int upvotes;
    private int downvotes;
}
