package com.example.codeclan.pirateservice.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "signups")
public class Signup {

    @ManyToOne
    private Pirate pirate;

    @ManyToOne
    private Raid raid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Signup() {
    }

    public Signup(Pirate pirate, Raid raid) {
        this.pirate = pirate;
        this.raid = raid;
    }

    public Pirate getPirate() {
        return pirate;
    }

    public void setPirate(Pirate pirate) {
        this.pirate = pirate;
    }

    public Raid getRaid() {
        return raid;
    }

    public void setRaid(Raid raid) {
        this.raid = raid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
