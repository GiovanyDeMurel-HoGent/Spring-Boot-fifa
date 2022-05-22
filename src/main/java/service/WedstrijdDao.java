package service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import domain.Wedstrijd;

public interface WedstrijdDao extends GenericDao<Wedstrijd>{
	
	public List<Wedstrijd> getAllWedstrijdenByStadiumId(Long id);
	

}
