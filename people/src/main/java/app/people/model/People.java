package app.people.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "people")
public class People {
	
	@Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    private String age;
    private String balance;
    private String email;
    private String address;

}
