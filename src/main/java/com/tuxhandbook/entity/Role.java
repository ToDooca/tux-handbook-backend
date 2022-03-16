package com.tuxhandbook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * User permissions
 */
@Entity
@Getter @Setter @NoArgsConstructor @ToString
@Table(name = "role")
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
    @ToString.Exclude
    private List<User> users;

    @Override
    public String getAuthority() {
        return String.format("ROLE_%s", name.toUpperCase(Locale.ROOT));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Role role = (Role) o;
        return id != null && Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
