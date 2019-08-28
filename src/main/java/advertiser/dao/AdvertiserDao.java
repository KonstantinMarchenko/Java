package advertiser.dao;

import java.util.List;

import advertiser.model.Advertiser;

public interface AdvertiserDao {

	public List<Advertiser> getAdvertisers();
	public Advertiser getAdvertiserById(Integer id);
	public void createAdvertiser(Advertiser advertiser);
	public boolean updateAdvertiser(Advertiser advertiser);
	public boolean deleteAdvertiserById(Integer id);
}