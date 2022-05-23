package service;

import java.util.List;

import domain.Wedstrijd;

public interface WedstrijdDao extends GenericDao<Wedstrijd>{
	
	public List<Wedstrijd> getAllWedstrijdenByStadiumId(Long id);
	

}
