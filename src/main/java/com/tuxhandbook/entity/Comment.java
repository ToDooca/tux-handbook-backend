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
public class Comment {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "comment_id")
    private int id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Post post;
    @ManyToOne
    private PC pc;
    @ManyToOne
    private Comment comment;
    private String body;
    private Integer upvotes;
    private Integer downvotes;
    private Boolean best_solution;
}
