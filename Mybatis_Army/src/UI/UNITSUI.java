package UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.UNITSDAO;
import VO.SUPPLIES;
import VO.UNITS;
import javax.swing.JList;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class UNITSUI extends JFrame implements ActionListener {
	private JTable table_2;
	private JList list;
	private UNITSDAO dao;
	private JTable givetable;
	private JTable havetable;

	public UNITSUI() {

		setSize(916, 564);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("\uBCF4\uAE09\uD488 \uBCF4\uC720\uD604\uD669");
		label.setBounds(17, 48, 212, 27);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("\uBCF4\uAE09\uD488 \uC811\uC218\uB0B4\uC5ED");
		label_1.setBounds(265, 51, 212, 27);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel("\uC608\uD558\uBD80\uB300 \uBCF4\uAE09\uD488 \uD604\uD669");
		label_2.setBounds(611, 48, 212, 27);
		getContentPane().add(label_2);

		/*
		 * JScrollPane scrollPane_2 = new JScrollPane(); scrollPane_2.setBounds(691,
		 * 164, 20, 37); getContentPane().add(scrollPane_2);
		 */
		makeGiveTable();
		makeHaveTable();
		setVisible(true);
	}

	public void makeGiveTable() {
		dao = new UNITSDAO();
		String columnNames[] = { "부대이름", "품명", "종명", "수량" };

		ArrayList<SUPPLIES> sList = dao.sList();
		System.out.println(sList);
		ArrayList<UNITS> ar = dao.ar();
		System.out.println(ar);
		Object rowData[][] = new Object[sList.size()][4];

		Collections.sort(sList);
		for (int j = 0; j < ar.size(); j++) {
			for (int i = 0; i < sList.size(); i++) {
				if ((ar.get(j).getUnits_seq() + "").equals(sList.get(i).getUnits_seq())) {
					rowData[i][0] = ar.get(j).getUnits_name();
					rowData[i][1] = sList.get(i).getSupplies_name();// 품명
					rowData[i][2] = sList.get(i).getSupply_class();// 종명
					rowData[i][3] = sList.get(i).getSupplies_quantity();// 수량
				}
			}
		}
		DefaultTableModel dtm = new DefaultTableModel(rowData, columnNames);
		givetable = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(givetable);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setBounds(611, 114, 212, 340);
		scrollPane.setViewportView(givetable);
	}

	public void makeHaveTable() {
		dao = new UNITSDAO();
		String columnNames[] = { "품명", "종명", "수량" };

		ArrayList<SUPPLIES> sList = dao.sList();
		ArrayList<SUPPLIES> resList = new ArrayList<>();
		ArrayList<UNITS> ar = dao.ar();
		System.out.println(ar);
		
		Collections.sort(sList);
		for (int i = 0; i < sList.size(); i++) {
			if (sList.get(i).getUnits_seq().equals("1")) {
				resList.add(sList.get(i));
			}
		}
		Object rowData[][] = new Object[resList.size()][3];
		System.out.println(resList);
		for (int i = 0; i < resList.size(); i++) {
				rowData[i][0] = sList.get(i).getSupplies_name();// 품명
				rowData[i][1] = sList.get(i).getSupply_class();// 종명
				rowData[i][2] = sList.get(i).getSupplies_quantity();// 수량
			
		}
		
	/*	for (int i = 0; i < sList.size(); i++) {
			if (sList.get(i).getUnits_seq().equals("1")) {
				rowData[i][0] = sList.get(i).getSupplies_name();// 품명
				rowData[i][1] = sList.get(i).getSupply_class();// 종명
				rowData[i][2] = sList.get(i).getSupplies_quantity();// 수량
			}
		}
		
		*//*
		 * for (int i = 0; i < sList.size(); i++) { if
		 * (sList.get(i).getUnits_seq().equals("1")) { rowData[i][0] =
		 * sList.get(i).getSupplies_name();// 품명 rowData[i][1] =
		 * sList.get(i).getSupply_class();// 종명 rowData[i][2] =
		 * sList.get(i).getSupplies_quantity();// 수량 } }
		 */
		
		DefaultTableModel dtm = new DefaultTableModel(rowData, columnNames);
		havetable = new JTable(dtm);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(27, 114, 198, 340);
		getContentPane().add(scrollPane_1);
		scrollPane_1.setViewportView(havetable);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}