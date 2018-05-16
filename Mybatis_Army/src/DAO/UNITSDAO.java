package DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.SUPPLIES;
import VO.UNITS;

public class UNITSDAO {
   private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
   
   public void insertUNITS(UNITS vo) {
      SqlSession session = null;
      try {
         session = factory.openSession();
         UNITSMapper mapper = session.getMapper(UNITSMapper.class);
         mapper.insertUNITS(vo);
         session.commit();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         session.close();
      }
   }  
   public ArrayList<UNITS> ar(){
	      SqlSession session = null;
	      ArrayList <UNITS> result = null;
	      try {
	         session = factory.openSession();
	         UNITSMapper mapper = session.getMapper(UNITSMapper.class);
	         result = mapper.ar();
	         session.commit();
	      } catch (Exception e) {
	         // TODO: handle exception
	         e.printStackTrace();
	      }finally {
	         session.close();
	      }
	      return result;
	      
	   }
   public void insertSUPPLIES(SUPPLIES vo) {
	      SqlSession session = null;
	      try {
	         session = factory.openSession();
	         SUPPLIESMapper mapper = session.getMapper(SUPPLIESMapper.class);
	         mapper.insertSUPPLIES(vo);
	         session.commit();
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	   }  
   
   public ArrayList<SUPPLIES> sList(){
      SqlSession session = null;
      ArrayList <SUPPLIES> result = null;
      try {
         session = factory.openSession();
         SUPPLIESMapper mapper = session.getMapper(SUPPLIESMapper.class);
         result = mapper.sList();
         session.commit();
      } catch (Exception e) {
         // TODO: handle exception
         e.printStackTrace();
      }finally {
         session.close();
      }
      return result;
      
   }
   
}