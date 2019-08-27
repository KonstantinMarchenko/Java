package Advertiser.dao;

import java.util.List;

import Advertiser.model.Advertiser;

public interface AdvertiserDao {

	public List<Advertiser> GetAdvertisers();
	public Advertiser GetAdvertiserById(Integer Id);
	public void CreateAdvertiser(Advertiser Advertiser);
	public boolean UpdateAdvertiser(Advertiser Advertiser);
	public boolean DeleteAdvertiserById(Integer Id);
}