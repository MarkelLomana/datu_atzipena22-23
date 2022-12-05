package com.example.accessingdatamysql;

import javax.persistence.*;

@Entity
public class Session {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Eguna")
	private String eguna;

	@Column(name = "Iraupena")
	private String iraupena;

    @ManyToOne
    @JoinColumn(name = "erabiltzailea")
	private Erabiltzailea erabiltzailea;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEguna() {
        return eguna;
    }

    public void setEguna(String eguna) {
        this.eguna = eguna;
    }

    public String getIraupena() {
        return iraupena;
    }

    public void setIraupena(String iraupena) {
        this.iraupena = iraupena;
    }

    public Erabiltzailea getErabiltzailea() {
        return erabiltzailea;
    }

    public void setErabiltzailea(Erabiltzailea erabiltzailea) {
        this.erabiltzailea = erabiltzailea;
    }

	
}
