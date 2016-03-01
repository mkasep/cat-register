package ttu.idu0080.rest.data;
import javax.persistence.Column;
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.Table;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;


@Entity
@Table(name="CAT")
public class Cat implements java.io.Serializable  {
	@Id  
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id ;
	private String name;
	private String character;
	private String color;
	private int age;


	public Cat() {
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCharacter() {
		return character;
	}


	public void setCharacter(String character) {
		this.character = character;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}



}
