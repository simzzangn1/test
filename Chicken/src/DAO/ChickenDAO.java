package DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.ChickenVO;
import VO.EggVO;

public class ChickenDAO {

	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체

	public void insertChicken(ChickenVO vo) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			ChickenMapper mapper = session.getMapper(ChickenMapper.class);
			mapper.insertChicken(vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void insertEgg(EggVO vo) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			ChickenMapper mapper = session.getMapper(ChickenMapper.class);
			mapper.insertEgg(vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public ArrayList<ChickenVO> chickenList() {
		SqlSession session = null;
		ArrayList<ChickenVO> result = null;
		try {
			session = factory.openSession();
			ChickenMapper mapper = session.getMapper(ChickenMapper.class);
			result = mapper.chickenList();
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}
	
	public ArrayList<EggVO> eggList() {
		SqlSession session = null;
		ArrayList<EggVO> result = null;
		try {
			session = factory.openSession();
			ChickenMapper mapper = session.getMapper(ChickenMapper.class);
			result = mapper.eggList();
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}
	
	public void deleteChicken(String chicken_seq) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			ChickenMapper mapper = session.getMapper(ChickenMapper.class);
			mapper.deleteChicken(chicken_seq);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
