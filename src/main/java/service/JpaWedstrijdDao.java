package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.Wedstrijd;

@Repository("wedstrijdDao")
public class JpaWedstrijdDao extends GenericDaoJpa<Wedstrijd> implements WedstrijdDao {

	public JpaWedstrijdDao() {
		super(Wedstrijd.class);
	}
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly = true)
	public List<Wedstrijd> getAllWedstrijdenByStadiumId(Long id) {
		TypedQuery<Wedstrijd> query = em.createNamedQuery("Wedstrijd.getAllWedstrijdenByStadiumId", Wedstrijd.class);
		query.setParameter("stadium_id", id);
		return query.getResultList();
	}
	
	
}
