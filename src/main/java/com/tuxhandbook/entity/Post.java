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
    private int id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Category category;
    @ManyToOne
    private PC pc;
    private String title;
    private String body;
    private Integer upvotes = 0;
    private Integer downvotes = 0;
}
