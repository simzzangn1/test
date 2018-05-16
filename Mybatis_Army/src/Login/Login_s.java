package Login;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import DAO.UNITSDAO;
import Main.UNITSMain;
import UI.UNITSUI;
import UI.USERUI;
import VO.UNITS;
import makeUser.makeUserUI;

import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Login_s extends JFrame implements ActionListener {
	private JTextField textID;
	private JButton btnLogin;
	private JButton btnReset;
	private JButton btnJoin;
	private UNITSDAO dao;
	private JPasswordField passwordField;

	public Login_s() {
		setSize(400, 300);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uB85C\uADF8\uC778");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 28));
		lblNewLabel.setBounds(146, 10, 97, 27);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setBounds(31, 80, 57, 15);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_2.setBounds(31, 128, 57, 15);
		getContentPane().add(lblNewLabel_2);

		textID = new JTextField();
		textID.setBounds(146, 77, 116, 21);
		getContentPane().add(textID);
		textID.setColumns(10);

		btnLogin = new JButton("\uB85C\uADF8\uC778");
		btnLogin.setBounds(31, 206, 97, 23);
		btnLogin.addActionListener(this);
		getContentPane().add(btnLogin);

		btnReset = new JButton("\uC7AC\uC124\uC815");
		btnReset.setBounds(146, 206, 97, 23);
		btnReset.addActionListener(this);
		getContentPane().add(btnReset);

		JSeparator separator = new JSeparator();
		separator.setBounds(12, 189, 360, 7);
		getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 47, 360, 9);
		getContentPane().add(separator_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(146, 125, 116, 21);
		getContentPane().add(passwordField);
		
				btnJoin = new JButton("\uD68C\uC6D0\uAC00\uC785");
				btnJoin.setBounds(275, 206, 97, 23);
				btnJoin.addActionListener(this);
				getContentPane().add(btnJoin);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnJoin) {
			new makeUserUI();
		} else if (e.getSource() == btnLogin) {

			String id = textID.getText();
			String password = passwordField.getText();

			String name = login(id, password);

			if (name == null) {
				JOptionPane.showMessageDialog(null, "정보를 정확하게 입력하세요.", "Login Error", JOptionPane.ERROR_MESSAGE);
				passwordField.setText(null);
				textID.setText(null);
			} else if(id.equals("admin")){
				passwordField.setText(null);
				textID.setText(null);
				new UNITSUI();
			}else {
				new USERUI();
			}
		} else if (e.getSource() == btnReset) {
			textID.setText(null);
			passwordField.setText(null);
		}
	}

	public String login(String id, String password) {
		String result = null;
		dao = new UNITSDAO();
		ArrayList<UNITS> ar = dao.ar();
		for (int i = 0; i < ar.size(); i++) {
			if (ar.get(i).getUnit_username() != null && ar.get(i).getUnit_password() != null
					&& ar.get(i).getUnit_username().equals(id) && ar.get(i).getUnit_password().equals(password)) {
				result = ar.get(i).getUnits_name();
			}
		}
		return result;
	}
}
