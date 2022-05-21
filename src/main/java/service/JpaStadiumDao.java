package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.Stadium;

@Repository("guestDao")
public class JpaStadiumDao implements StadiumDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly = true)
	public List<Stadium> findAll() {
		TypedQuery<Stadium> query = em.createNamedQuery("Stadium.findAll", Stadium.class);
		return query.getResultList();
	}

}
