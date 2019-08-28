package advertiser.service;


import advertiser.model.Advertiser;

import java.util.List;

public interface AdvertiserService {

    public List<Advertiser> getAdvertisersFromService();

    public Advertiser getAdvertiserFromService(int id);

    public void createAdvertiser(Advertiser advertiser);

    public boolean updateAdvertiser(Advertiser advertiser);

    public boolean deleteAdvertiser(int id);

    public boolean checkCreditLimit(int id);

}