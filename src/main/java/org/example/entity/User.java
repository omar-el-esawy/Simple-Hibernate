package org.example.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "your_table_name")
@Setter
@Getter
public class User {
    @Id
    private int id;

    private String name;


}
