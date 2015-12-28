package fab.formatic.backend.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabTariffDao;
import fab.formatic.backend.domain.FabTariff;
import fab.formatic.backend.util.FabBeansLocator;

@Repository(FabBeansLocator.TARIFF_DAO)
public class FabTariffDaoImpl extends FabBaseDao<FabTariff, Integer> implements FabTariffDao {

	public FabTariffDaoImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<FabTariff> findByDate(Date date) {
		Query q=entityManager.createQuery("select t from FabTariff t");
		List<FabTariff> result=q.getResultList();
		
		List<FabTariff> query=new ArrayList<FabTariff>();
		
		for(FabTariff t:result)
		{
			if(t.getSalesStart().after(date) && t.getSalesEnd().before(date)){
				query.add(t);
			}
		}
		return query;
	}

	@SuppressWarnings("unchecked")
	public List<FabTariff> findByPeriod(String period) {
		Query q=entityManager.createQuery("select s from FabTariff s where s.fabTariff.period=:period");
		q.setParameter("period", period);
		return q.getResultList();
	}

}
