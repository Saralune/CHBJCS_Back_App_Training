package com.example.apitrainings.security.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class Uuser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "USER_NAME")
    private String userName;

    private String password;

    private Boolean active;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)@JsonIgnore
    private List<Rrole> roles = new ArrayList<>();

    @Override
    public String toString() {
        return "Uuser [userId=" + userId + ", userName=" + userName + ", password=" + password + ", active=" + active
                + ", roles=" + roles + "]";
    }

    public Uuser(long userId, @NotNull String userName, @NotNull String password, Boolean active) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.active = active;
    }

}
