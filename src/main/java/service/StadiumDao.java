package service;

import java.util.List;

import domain.Stadium;

public interface StadiumDao extends GenericDao<Stadium> {

	public List<Stadium> findAll();
}
