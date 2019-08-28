package advertiser.dao;

import advertiser.BatisUtil;
import advertiser.model.Advertiser;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdvertiserDaoImpl implements AdvertiserDao {

    @Override
    public List<Advertiser> getAdvertisers() {
        SqlSession session = BatisUtil.getSqlSessionFactory().openSession();
        List<Advertiser> advertisers = session.selectList("advertiser.AdvertiserMapper.selectAdvertisers");
        session.close();
        return advertisers;
    }

    @Override
    public Advertiser getAdvertiserById(Integer id) {
        SqlSession session = BatisUtil.getSqlSessionFactory().openSession();
        Advertiser advertiser = session.selectOne("advertiser.AdvertiserMapper.selectAdvertiser", id);
        session.close();
        return advertiser;
    }

    @Override
    public void createAdvertiser(Advertiser advertiser) {
        SqlSession session = BatisUtil.getSqlSessionFactory().openSession();
        session.insert("advertiser.AdvertiserMapper.insertAdvertiser", advertiser);
        session.commit();
        session.close();
    }

    @Override
    public boolean updateAdvertiser(Advertiser advertiser) {
        boolean success = true;
        SqlSession session = BatisUtil.getSqlSessionFactory().openSession();
        Advertiser existingAdv = session.selectOne("advertiser.AdvertiserMapper.selectAdvertiser", advertiser.getId());
        if (null == existingAdv) success = false;

        if (success) {
            session.update("advertiser.AdvertiserMapper.updateAdvertiser", advertiser);
            session.commit();
        }

        session.close();
        return success;
    }

    @Override
    public boolean deleteAdvertiserById(Integer id) {
        boolean success = true;
        SqlSession session = BatisUtil.getSqlSessionFactory().openSession();
        Advertiser existingAdv = session.selectOne("advertiser.AdvertiserMapper.selectAdvertiser", id);
        if (null == existingAdv) success = false;

        if (success) {
            session.delete("advertiser.AdvertiserMapper.deleteAdvertiser", id);
            session.commit();
        }

        session.close();
        return success;
    }

}