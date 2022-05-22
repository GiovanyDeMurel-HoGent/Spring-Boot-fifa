package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Een wedstrijd
@Entity
@Table(name = "wedstrijd")
public class Wedstrijd implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wedstrijd_id; //unieke sleutel

    private String land1, land2; //2 landen van de wedstrijd
    
    private Date datetime;

	public Wedstrijd(Long wedstrijd_id, String land1, String land2, Date datetime) {
		super();
		this.wedstrijd_id = wedstrijd_id;
		this.land1 = land1;
		this.land2 = land2;
		this.datetime = datetime;
	}

	public Long getWedstrijd_id() {
		return wedstrijd_id;
	}

	public void setWedstrijd_id(Long wedstrijd_id) {
		this.wedstrijd_id = wedstrijd_id;
	}

	public String getLand1() {
		return land1;
	}

	public void setLand1(String land1) {
		this.land1 = land1;
	}

	public String getLand2() {
		return land2;
	}

	public void setLand2(String land2) {
		this.land2 = land2;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	@Override
	public String toString() {
		return "Wedstrijd [wedstrijd_id=" + wedstrijd_id + ", land1=" + land1 + ", land2=" + land2 + ", datetime="
				+ datetime + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(wedstrijd_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wedstrijd other = (Wedstrijd) obj;
		return Objects.equals(wedstrijd_id, other.wedstrijd_id);
	}
    
    
    
    //private int dag; //dag van de wedstrijd

    //private int uur; //uur van de wedstrijd

//    public Wedstrijd() {
//    }
//
//    public Wedstrijd(String id, String[] landen, int dag, int uur) {
//        this.id = id;
//        this.landen = landen;
//        this.dag = dag;
//        this.uur = uur;
//    }
//
//    public String getWedstrijd_Id() {
//        return id;
//    }
//
//    public String[] getLanden() {
//        return landen;
//    }
//
//    public int getDag() {
//        return dag;
//    }
//
//    public int getUur() {
//        return uur;
//    }
    
//    @Override
//    public String toString()
//    {
//        return String.format("%s vs %s op %d-11", landen[0], landen[1], dag); 
//    }


}
