package makeUser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.UNITSDAO;
import Login.Login_s;
import VO.UNITS;

import java.awt.Font;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JPasswordField;

public class makeUserUI extends JFrame implements ActionListener {
	private JTextField Username;
	private JTextField Unitname;
	private JButton btnJoin;
	private JButton btnReset;
	private JButton btnUsernameDuplication;
	private JButton btnUnitnameduplication;
	private JLabel lblNewLabel;
	private UNITSDAO dao = new UNITSDAO();;
	// private ArrayList<UNITS> ali = new ArrayList<UNITS>();
	// private ArrayList<UNITS> voo = new ArrayList<UNITS>();
	private JPasswordField Password;
	private JPasswordField Repassword;
	private JButton btnReconfirm;

	public makeUserUI() {
		setSize(522, 493);
		setTitle("부대회원가입ver.01");
		getContentPane().setLayout(null);

		lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(141, 10, 99, 34);
		getContentPane().add(lblNewLabel);

		JLabel lblUsername = new JLabel("\uC544\uC774\uB514");
		lblUsername.setBounds(53, 75, 57, 15);
		getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblPassword.setBounds(53, 126, 57, 15);
		getContentPane().add(lblPassword);

		JLabel lblRepassword = new JLabel("\uBE44\uBC00\uBC88\uD638 \uC7AC\uC785\uB825");
		lblRepassword.setBounds(53, 183, 99, 15);
		getContentPane().add(lblRepassword);

		JLabel lblUnitname = new JLabel("\uBD80\uB300\uC774\uB984");
		lblUnitname.setBounds(53, 241, 57, 15);
		getContentPane().add(lblUnitname);

		Username = new JTextField();
		Username.setBounds(164, 75, 116, 21);
		getContentPane().add(Username);
		Username.setColumns(10);

		Unitname = new JTextField();
		Unitname.setBounds(164, 241, 116, 21);
		getContentPane().add(Unitname);
		Unitname.setColumns(10);

		btnReset = new JButton("\uC7AC\uC124\uC815");
		btnReset.setBounds(110, 328, 97, 23);
		getContentPane().add(btnReset);
		btnReset.addActionListener(this);

		btnUsernameDuplication = new JButton("\uC911\uBCF5\uD655\uC778");
		btnUsernameDuplication.setBounds(312, 75, 97, 23);
		getContentPane().add(btnUsernameDuplication);
		btnUsernameDuplication.addActionListener(this);

		btnUnitnameduplication = new JButton("\uC911\uBCF5\uD655\uC778");
		btnUnitnameduplication.setBounds(312, 237, 97, 23);
		getContentPane().add(btnUnitnameduplication);

		btnJoin = new JButton("\uAC00\uC785");
		btnJoin.setBounds(248, 328, 97, 23);
		getContentPane().add(btnJoin);

		Password = new JPasswordField();
		Password.setEchoChar('*');
		Password.setBounds(164, 123, 116, 21);
		getContentPane().add(Password);

		Repassword = new JPasswordField();
		Repassword.setEchoChar('*');
		Repassword.setBounds(164, 180, 116, 21);
		getContentPane().add(Repassword);

		btnReconfirm = new JButton("\uC7AC\uD655\uC778");
		btnReconfirm.setBounds(312, 179, 97, 23);
		getContentPane().add(btnReconfirm);
		btnReconfirm.addActionListener(this);
		btnJoin.addActionListener(this);
		btnUnitnameduplication.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnJoin) {

			String username = Username.getText();
			String password = Password.getText();
			String repassword = Repassword.getText();
			String unitname = Unitname.getText();
			UNITS vo = new UNITS();
			boolean joinCheck = joinCheck(username, unitname);
			if (joinCheck != true) {
				JOptionPane.showMessageDialog(this, "정보를 정확하게 입력하세요.", "경고", JOptionPane.WARNING_MESSAGE);
			} else {
				vo.setUnits_name(unitname);
				vo.setUnit_username(username);
				vo.setUnit_password(password);
				dao.insertUNITS(vo);
				JOptionPane.showMessageDialog(this, "가입완료", "정보", JOptionPane.INFORMATION_MESSAGE);
				Login_s a = new Login_s();
			}

		} else if (e.getSource() == btnReset) {
			Username.setText(null);
			Password.setText(null);
			Repassword.setText(null);
			Unitname.setText(null);
		} else if (e.getSource() == btnUsernameDuplication) {
			String username = Username.getText();

			boolean idCheck = idCheck(username);
			if (idCheck != true) {
				JOptionPane.showMessageDialog(this, "중복된 아이디가 존재합니다.", "경고", JOptionPane.WARNING_MESSAGE);
				Username.setText(null);
			} else {
				JOptionPane.showMessageDialog(this, "사용할 수 있는 아이디입니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
			}

		} else if (e.getSource() == btnReconfirm) {

			String password = Password.getText();
			String repassword = Repassword.getText();

			if (password.equals(repassword)) {
				JOptionPane.showMessageDialog(null, "사용할수 있는 비밀번호입니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "비밀번호를 정확하게 입력하세요.", "알림", JOptionPane.WARNING_MESSAGE);
				Password.setText(null);
				Repassword.setText(null);
			}
		} else if (e.getSource() == btnUnitnameduplication) {

			String unitname = Unitname.getText();
			boolean unitCheck = unitCheck(unitname);
			if (unitCheck != true) {
				JOptionPane.showMessageDialog(null, "중복된 부대정보를 입력하였습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				Unitname.setText(null);
			} else {
				JOptionPane.showMessageDialog(null, "사용할 수있는 부대정보입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public boolean idCheck(String id) {
		boolean result = true;
		ArrayList<UNITS> ali = dao.ar();
		for (int i = 0; i < ali.size(); i++) {
			if (ali.get(i).getUnit_username().equals(id)) {
				result = false;
			}

		}
		return result;
	}

	public boolean unitCheck(String unitname) {
		boolean result = true;
		ArrayList<UNITS> ali = dao.ar();
		for (int i = 0; i < ali.size(); i++) {
			if (ali.get(i).getUnits_name().equals(unitname)) {
				result = false;
			}
		}
		return result;
	}

	public boolean joinCheck(String unitname, String username) {
		boolean result = true;
		ArrayList<UNITS> ali = dao.ar();
		for (int i = 0; i < ali.size(); i++) {
			if (ali.get(i).getUnit_username() != null && ali.get(i).getUnit_password() != null
					&&ali.get(i).getUnits_name().equals(unitname)) {
				result = false;
			} else if (ali.get(i).getUnit_username().equals(username)) {
				result = false;
			}
		}
		return result;
	}
}
