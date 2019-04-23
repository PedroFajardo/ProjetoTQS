package com2.cloudDomus;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Works {

private @Id @GeneratedValue Long id;
    private String name;
    private int numberWorkers;
    private String description;

    //public Works(){}
    
    public Works(String name, int numberWorkers, String description) { //adicionar o que for preciso nos argumentos...
        this.name = name;
        this.numberWorkers = numberWorkers;
        this.description = description;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberWorkers() {
		return numberWorkers;
	}

	public void setNumberWorkers(int numberWorkers) {
		this.numberWorkers = numberWorkers;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}