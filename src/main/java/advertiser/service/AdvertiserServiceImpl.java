package advertiser.service;

import advertiser.dao.AdvertiserDao;
import advertiser.model.Advertiser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertiserServiceImpl implements AdvertiserService {

    @Autowired
    AdvertiserDao dao;

    @Override
    public List<Advertiser> getAdvertisersFromService() {
        return dao.getAdvertisers();
    }

    @Override
    public Advertiser getAdvertiserFromService(int id) {
        return dao.getAdvertiserById(id);
    }

    @Override
    public void createAdvertiser(Advertiser advertiser) {
        dao.createAdvertiser(advertiser);
    }

    @Override
    public boolean updateAdvertiser(Advertiser advertiser) {
        return dao.updateAdvertiser(advertiser);
    }

    @Override
    public boolean deleteAdvertiser(int id) {
        return dao.deleteAdvertiserById(id);
    }

    @Override
    public boolean checkCreditLimit(int id) {
        Advertiser advertiser = getAdvertiserFromService(id);
        return advertiser.getCreditLimit() > 100;
    }
}