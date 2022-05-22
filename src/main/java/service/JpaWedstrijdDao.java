package service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.Wedstrijd;

@Repository("wedstrijdDao")
public class JpaWedstrijdDao extends GenericDaoJpa<Wedstrijd> implements WedstrijdDao {

	public JpaWedstrijdDao() {
		super(Wedstrijd.class);
	}
	
	@Transactional(readOnly = true)
	public List<Wedstrijd> getAllWedstrijdenByStadiumId(Long id) {
		TypedQuery<Wedstrijd> query = em.createNamedQuery("Wedstrijd.getAllWedstrijdenByStadiumId", Wedstrijd.class);
		return query.getResultList();
	}
}
