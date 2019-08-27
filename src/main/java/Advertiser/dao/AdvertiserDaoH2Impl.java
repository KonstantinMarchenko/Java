package Advertiser.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import Advertiser.BatisUtil;
import Advertiser.model.Advertiser;

@Repository
public class AdvertiserDaoH2Impl implements AdvertiserDao {

	@Override
	public List<Advertiser> GetAdvertisers() {
		SqlSession session = BatisUtil.getSqlSessionFactory().openSession();	
		  List<Advertiser> advertisers = session.selectList("Advertiser.AdvertiserMapper.selectAdvertisers");
		  session.close();
		  return advertisers;
	}	

	@Override
	public Advertiser GetAdvertiserById(Integer id) {
	      SqlSession session = BatisUtil.getSqlSessionFactory().openSession();	
		  Advertiser advertiser = session.selectOne("Advertiser.AdvertiserMapper.selectAdvertiser", id);
		  session.close();
		  return advertiser;
	}

	@Override
	public void CreateAdvertiser(Advertiser advertiser) {
		 SqlSession session = BatisUtil.getSqlSessionFactory().openSession();	
		  session.insert("Advertiser.AdvertiserMapper.insertAdvertiser", advertiser);
		  session.commit();
		  session.close();
	}

	@Override
	public boolean UpdateAdvertiser(Advertiser advertiser) {
		boolean success = true;
		SqlSession session = BatisUtil.getSqlSessionFactory().openSession();
		Advertiser existingAdv = session.selectOne("Advertiser.AdvertiserMapper.selectAdvertiser", advertiser.getId());
		if (null == existingAdv) success = false;
		  
		if (success) {
			session.update("Advertiser.AdvertiserMapper.updateAdvertiser", advertiser);
			session.commit();
		}
		  
		session.close();
		return success;
	}

	@Override
	public boolean DeleteAdvertiserById(Integer id) {
		  boolean success = true;
		  SqlSession session = BatisUtil.getSqlSessionFactory().openSession();
		  Advertiser existingAdv = session.selectOne("Advertiser.AdvertiserMapper.selectAdvertiser", id);
		  if (null == existingAdv) success = false;
		  
		  if (success) {
			  session.delete("Advertiser.AdvertiserMapper.deleteAdvertiser", id);
			  session.commit();
		  }
		  
		  session.close();
		  return success;
	}
	
}

