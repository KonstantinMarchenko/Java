package Advertiser.service;


import java.util.List;

import Advertiser.model.Advertiser;

public interface AdvertiserService {

	public List<Advertiser> GetAdvertisersFromService();
	public Advertiser GetAdvertiserFromService(int id);
	public void CreateAdvertiser(Advertiser advertiser);
	public boolean UpdateAdvertiser(Advertiser advertiser);
	public boolean DeleteAdvertiser(int id);
	public boolean CheckCreditLimit(int id);

}