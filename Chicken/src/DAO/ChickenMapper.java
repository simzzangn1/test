package DAO;

import java.util.ArrayList;

import VO.ChickenVO;
import VO.EggVO;

public interface ChickenMapper {
	
	public void insertChicken(ChickenVO vo);
	
	public void insertEgg(EggVO vo);
	
	public ArrayList<ChickenVO> chickenList();
	
	public ArrayList<EggVO> eggList();
	
	public void deleteChicken(String chicken_seq);

}
