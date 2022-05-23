package service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import domain.Stadium;

@Repository("stadiumDao")
public class JpaStadiumDao extends GenericDaoJpa<Stadium> implements StadiumDao{

	public JpaStadiumDao() {
		super(Stadium.class);
	}
	
	@PersistenceContext
	private EntityManager em;

}
