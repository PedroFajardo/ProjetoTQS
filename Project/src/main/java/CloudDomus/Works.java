package CloudDomus;

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


    public Works(String name, int numberWorkers, String description) { //adicionar o que for preciso nos argumentos...
        this.name = name;
        this.numberWorkers = numberWorkers;
        this.description = description;
    }
}