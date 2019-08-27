package Advertiser.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Advertiser.dao.AdvertiserDao;
import Advertiser.model.Advertiser;

@Service
public class AdvertiserServiceImpl implements AdvertiserService {

	@Autowired
	AdvertiserDao dao;

	@Override
	public List<Advertiser> GetAdvertisersFromService() {
		return dao.GetAdvertisers();	
	}

	@Override
	public Advertiser GetAdvertiserFromService(int id) {
		return dao.GetAdvertiserById(id);
	}

	@Override
	public void CreateAdvertiser(Advertiser advertiser) {
		dao.CreateAdvertiser(advertiser);	
	}

	@Override
	public boolean UpdateAdvertiser(Advertiser advertiser) {
		return dao.UpdateAdvertiser(advertiser);		
	}

	@Override
	public boolean DeleteAdvertiser(int id) {
		return dao.DeleteAdvertiserById(id);
	}

	@Override
	public boolean CheckCreditLimit(int id) {
		Advertiser adv = GetAdvertiserFromService(id);	
		return adv.getCreditlimit()>100;
	}

	
}