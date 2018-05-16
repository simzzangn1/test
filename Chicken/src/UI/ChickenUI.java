package UI;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.ChickenDAO;
import VO.ChickenVO;
import VO.EggVO;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.sound.midi.Synthesizer;
import javax.swing.JButton;
import javax.swing.JTable;

public class ChickenUI extends JFrame implements ActionListener{
	
	private JTextField textField;//´ßÇ°Á¾
	private JTextField textField_1;//´ßµî±Þ
	private JTextField textField_2;//´ß³ªÀÌ
	private JButton btnNewButton;//´ßµî·Ï
	private ChickenDAO dao;
	private JList list;
	private JScrollPane scrollPane_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;//´ß»èÁ¦

	public ChickenUI() {
		dao=new ChickenDAO();
		setSize(500, 579);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 29, 217, 353);
		getContentPane().add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		textField = new JTextField();
		textField.setBounds(115, 394, 116, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(115, 430, 116, 24);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(115, 466, 116, 24);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uD488\uC885");
		lblNewLabel.setBounds(24, 394, 62, 18);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uB4F1\uAE09");
		lblNewLabel_1.setBounds(24, 433, 62, 18);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uB098\uC774");
		lblNewLabel_2.setBounds(24, 469, 62, 18);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(24, 505, 62, 18);
		getContentPane().add(lblNewLabel_3);
		
		btnNewButton = new JButton("\uB4F1\uB85D");
		btnNewButton.setBounds(14, 502, 105, 27);
		btnNewButton.addActionListener(this);
		getContentPane().add(btnNewButton);
		
		
		
		textField_3 = new JTextField();
		textField_3.setBounds(352, 394, 116, 24);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(352, 430, 116, 24);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		lblNewLabel_4 = new JLabel("\uC54C\uB4F1\uAE09");
		lblNewLabel_4.setBounds(261, 397, 62, 18);
		getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("\uC54C\uAC00\uACA9");
		lblNewLabel_5.setBounds(261, 433, 62, 18);
		getContentPane().add(lblNewLabel_5);
		
		btnNewButton_1 = new JButton("\uB4F1\uB85D");
		btnNewButton_1.setBounds(261, 502, 105, 27);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		
		btnNewButton_2 = new JButton("\uC0AD\uC81C");
		btnNewButton_2.setBounds(126, 502, 105, 27);
		btnNewButton_2.addActionListener(this);
		getContentPane().add(btnNewButton_2);
		
		refreshList();
		makeTable();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnNewButton) {
			String kind=textField.getText();
			String grade=textField_1.getText();
			String age=textField_2.getText();
			
			ChickenVO vo=new ChickenVO();
			vo.setChicken_kind(kind);
			vo.setChicken_grade(grade);
			vo.setChicken_age(age);
			dao.insertChicken(vo);
			refreshList();
		}else if(e.getSource()==btnNewButton_1) {
			String egg_price =textField_3.getText();
			String egg_grade =textField_4.getText();
			EggVO vo=new EggVO();
			vo.setEgg_grade(egg_grade);
			vo.setEgg_price(egg_price);
			dao.insertEgg(vo);
			makeTable();
		}else if(e.getSource()==btnNewButton_2) {
			ChickenVO vo=dao.chickenList().get(list.getSelectedIndex());
			String chicken_seq=vo.getChicken_seq();
			dao.deleteChicken(chicken_seq);
			refreshList();
		}
	}
	
	public void refreshList() {
		list.setListData(dao.chickenList().toArray());
	}
	
	public void makeTable() {
		
		
		String columnNames[]= {"¾Ë°íÀ¯¹øÈ£","¾Ë°¡°Ý","¾Ëµî±Þ"};
		
	    ArrayList<EggVO> eggList=dao.eggList();
	    
		Object rowData [][]= new Object[eggList.size()][3]; 
		
		for(int i=0;i<eggList.size();i++) {
			rowData[i][0]=eggList.get(i).getEgg_seq();
			rowData[i][1]=eggList.get(i).getEgg_price();
			rowData[i][2]=eggList.get(i).getEgg_grade();
		
		}
		
		DefaultTableModel dtm=new DefaultTableModel(rowData,columnNames);
		JTable jtable=new JTable(dtm);
		
		scrollPane_1 = new JScrollPane(jtable);
		scrollPane_1.setBounds(261, 29, 207, 353);
		getContentPane().add(scrollPane_1);
		
		
		
		
	}
}
