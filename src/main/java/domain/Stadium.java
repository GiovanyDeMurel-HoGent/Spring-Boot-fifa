package domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import service.VoetbalServiceImpl;

@Entity
@NamedQueries({
	@NamedQuery(name="Stadium.findAll", 
		query = "SELECT s FROM Stadium s ORDER BY s.stadium_id")
})
@Table(name = "stadium")
public class Stadium implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stadium_id;
	
	private String name;
	
	protected Stadium() {
		
	}
	
	public Long getID() {
		return stadium_id;
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
