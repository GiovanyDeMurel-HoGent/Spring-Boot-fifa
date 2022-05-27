package domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "stadium")
public class Stadium implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stadium_id;
	
	private String name;
	
//	@OneToMany
//	private Set<Wedstrijd> wedstrijden;
	
	public Stadium() {
		
	}
	
//	public Long getID() {
//		return stadium_id;
//	}

	public Stadium(Long stadium_id, String name) {
		super();
		this.stadium_id = stadium_id;
		this.name = name;
	}

	public Long getStadium_id() {
		return stadium_id;
	}

	public void setStadium_id(Long stadium_id) {
		this.stadium_id = stadium_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stadium other = (Stadium) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return String.format("%s", name);
	}
	
	
	
}
