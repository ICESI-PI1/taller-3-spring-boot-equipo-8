package com.compunet.bookstore.persistence.models;

import org.springframework.stereotype.Component;

<<<<<<< HEAD
@Data
@RequiredArgsConstructor
=======
import java.util.Date;

@Component
>>>>>>> b4d605f35f1a1b5f097a3a1fd9d668fd60710e67
public class Autor {


    private Long id;
    private String name;
    private String nationality;

    public Autor(){

    }
    public Autor(long id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Autor(id: " + id + "; name: " + name + "; nationality: " + nationality +")";
    }
}
