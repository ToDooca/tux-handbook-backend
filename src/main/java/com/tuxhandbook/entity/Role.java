package com.tuxhandbook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;
import java.util.Locale;

/**
 * User permissions
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "role")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Role extends Auditable implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "role_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "role_fk"), inverseJoinColumns = @JoinColumn(name = "user_fk"))
    private List<User> users;

    @Override
    public String getAuthority() {
        return String.format("ROLE_%s", name.toUpperCase(Locale.ROOT));
    }
}
