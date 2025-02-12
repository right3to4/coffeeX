package com.coffeex.staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.coffeex.dto.StaffDto;
import com.coffeex.staffdao.ManagerAddStaffDao;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManagerAddStaff {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JButton btnSearch;
	private JTextField tfSearch;
	private JLabel lblNewLabel_3;
	private JTextField tfStaffId;
	private JLabel lblNewLabel_3_1;
	private JPasswordField pwfPassword;
	private JLabel lblNewLabel_3_2;
	private JPasswordField pwfReconfirm;
	private JLabel lbPasswordConfirm;
	private JLabel lblNewLabel_3_3;
	private JTextField tfStaffName;
	private JButton btnClear;
	private JButton btnDelete;
	private JButton btnInsert;
	private JTextField tfPhone;
	private JLabel lblNewLabel_3_3_1;
	private JTextField tfHourlyWage;
	private JLabel lblNewLabel_3_3_1_1;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JButton btnStaffIdCheck;
	boolean checkRegister = false;
	boolean checkPassword = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerAddStaff window = new ManagerAddStaff();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManagerAddStaff() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("사원등록/삭제");
		frame.getContentPane().setBackground(new Color(238, 238, 238));
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getBtnSearch());
		frame.getContentPane().add(getTfSearch());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getTfStaffId());
		frame.getContentPane().add(getLblNewLabel_3_1());
		frame.getContentPane().add(getPwfPassword());
		frame.getContentPane().add(getLblNewLabel_3_2());
		frame.getContentPane().add(getPwfReconfirm());
		frame.getContentPane().add(getLbPasswordConfirm());
		frame.getContentPane().add(getLblNewLabel_3_3());
		frame.getContentPane().add(getTfStaffName());
		frame.getContentPane().add(getBtnClear());
		frame.getContentPane().add(getBtnDelete());
		frame.getContentPane().add(getBtnInsert());
		frame.getContentPane().add(getTextField_3());
		frame.getContentPane().add(getLblNewLabel_3_3_1());
		frame.getContentPane().add(getTextField_1_1());
		frame.getContentPane().add(getLblNewLabel_3_3_1_1());
		frame.getContentPane().add(getComboBox());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getBtnStaffIdCheck());
		frame.setDefaultCloseOperation(2);
		tableInit();
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("  CoffeeX");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
			lblNewLabel.setBackground(new Color(148, 128, 96));
			lblNewLabel.setBounds(0, 0, 600, 50);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("사원검색");
			lblNewLabel_2.setBounds(373, 73, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					conditionQuery();
				}
			});
			btnSearch.setBounds(463, 101, 117, 29);
		}
		return btnSearch;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setColumns(10);
			tfSearch.setBounds(337, 101, 130, 26);
		}
		return tfSearch;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("사번");
			lblNewLabel_3.setBounds(19, 123, 61, 16);
		}
		return lblNewLabel_3;
	}
	private JTextField getTfStaffId() {
		if (tfStaffId == null) {
			tfStaffId = new JTextField();
			tfStaffId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					String REGEX = "[0-9]+";
					if(tfStaffId.getText().matches(REGEX)) {
					}else {
						JOptionPane.showMessageDialog(null, "숫자만 입력해 주세요.");
						tfStaffId.setText("");
					}
				}
			});
			tfStaffId.setColumns(10);
			tfStaffId.setBounds(19, 138, 130, 26);
		}
		return tfStaffId;
	}
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("비밀번호");
			lblNewLabel_3_1.setBounds(19, 282, 61, 16);
		}
		return lblNewLabel_3_1;
	}
	private JPasswordField getPwfPassword() {
		if (pwfPassword == null) {
			pwfPassword = new JPasswordField();
			pwfPassword.setBounds(19, 297, 130, 26);
		}
		return pwfPassword;
	}
	private JLabel getLblNewLabel_3_2() {
		if (lblNewLabel_3_2 == null) {
			lblNewLabel_3_2 = new JLabel("비밀번호 확인");
			lblNewLabel_3_2.setBounds(19, 322, 81, 16);
		}
		return lblNewLabel_3_2;
	}
	private JPasswordField getPwfReconfirm() {
		if (pwfReconfirm == null) {
			pwfReconfirm = new JPasswordField();
			pwfReconfirm.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					
				}
				@Override
				public void keyReleased(KeyEvent e) {
					if(pwCheck() == true) {
						lbPasswordConfirm.setText("");
					}else {
						lbPasswordConfirm.setText("비밀번호가 일치하지 않습니다.");
					}
				}
			});
			pwfReconfirm.setBounds(19, 337, 130, 26);
		}
		return pwfReconfirm;
	}
	private JLabel getLbPasswordConfirm() {
		if (lbPasswordConfirm == null) {
			lbPasswordConfirm = new JLabel("");
			lbPasswordConfirm.setForeground(Color.RED);
			lbPasswordConfirm.setBounds(161, 342, 158, 16);
		}
		return lbPasswordConfirm;
	}
	private JLabel getLblNewLabel_3_3() {
		if (lblNewLabel_3_3 == null) {
			lblNewLabel_3_3 = new JLabel("이름");
			lblNewLabel_3_3.setBounds(19, 163, 61, 16);
		}
		return lblNewLabel_3_3;
	}
	private JTextField getTfStaffName() {
		if (tfStaffName == null) {
			tfStaffName = new JTextField();
			tfStaffName.setColumns(10);
			tfStaffName.setBounds(19, 178, 130, 26);
		}
		return tfStaffName;
	}
	private JButton getBtnClear() {
		if (btnClear == null) {
			btnClear = new JButton("초기화");
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clearColumn();
				}
			});
			btnClear.setBounds(19, 364, 117, 29);
		}
		return btnClear;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제하기");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(deleteAction() == true) {
						JOptionPane.showMessageDialog(null, tfStaffName.getText()+"님의 정보가 삭제 되었습니다.");
						conditionQuery();
//						tableInit();
						clearColumn();
					}else {
						JOptionPane.showMessageDialog(null,"DB작업중 문제가 발생했습니다. \n행정실로 문의 하세요.");
					}
					
				}
			});
			btnDelete.setBounds(305, 399, 117, 29);
		}
		return btnDelete;
	}
	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("등록하기");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i_chk = insertFieldCheck();
					if(i_chk == 0) {
						if(checkRegister == true) {
							if(checkPassword == true) {
								insertAction();
								JOptionPane.showMessageDialog(null, tfStaffName.getText()+"님의 정보가 입력 되었습니다.");
								conditionQuery();
								clearColumn();
							}else {
								JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요.");
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "사번 중복확인을 확인해주세요.");
						}
//						int check = insertAction();
//						if(check == 1) {
//							JOptionPane.showMessageDialog(null, tfStaffName.getText()+"님의 정보가 입력 되었습니다.");
//							conditionQuery();
//							clearColumn();
//						}
					}
				}
			});
			btnInsert.setBounds(176, 399, 117, 29);
		}
		return btnInsert;
	}
	private JTextField getTextField_3() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBounds(19, 218, 130, 26);
		}
		return tfPhone;
	}
	private JLabel getLblNewLabel_3_3_1() {
		if (lblNewLabel_3_3_1 == null) {
			lblNewLabel_3_3_1 = new JLabel("전화번호");
			lblNewLabel_3_3_1.setBounds(19, 203, 61, 16);
		}
		return lblNewLabel_3_3_1;
	}
	private JTextField getTextField_1_1() {
		if (tfHourlyWage == null) {
			tfHourlyWage = new JTextField();
			tfHourlyWage.setColumns(10);
			tfHourlyWage.setBounds(19, 259, 130, 26);
		}
		return tfHourlyWage;
	}
	private JLabel getLblNewLabel_3_3_1_1() {
		if (lblNewLabel_3_3_1_1 == null) {
			lblNewLabel_3_3_1_1 = new JLabel("시급");
			lblNewLabel_3_3_1_1.setBounds(19, 244, 61, 16);
		}
		return lblNewLabel_3_3_1_1;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"사번", "이름", "전화번호"}));
			comboBox.setBounds(227, 102, 106, 27);
		}
		return comboBox;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(161, 135, 408, 163);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getButton() == 1) {
						tableClick();
					}
				}
			});
			Inner_Table.setShowVerticalLines(false);
			Inner_Table.setShowHorizontalLines(false);
			Inner_Table.setShowGrid(false);
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}
	
	private JButton getBtnStaffIdCheck() {
		if (btnStaffIdCheck == null) {
			btnStaffIdCheck = new JButton("중복확인");
			btnStaffIdCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					staffIdCheck();
					
				}
			});
			btnStaffIdCheck.setBounds(80, 115, 72, 29);
		}
		return btnStaffIdCheck;
	}
	//--------------------------------------funtcion-------------------------------
	private void tableInit() {
		
		Outer_Table.addColumn("사번");
		Outer_Table.addColumn("이름");
		Outer_Table.addColumn("전화번호");
		Outer_Table.addColumn("등록일");
		
		Outer_Table.setColumnCount(4);
		
		int i = Outer_Table.getRowCount();
		
		for(int j = 0; j<i; j++) {
			
			Outer_Table.removeRow(0);
		}
		
		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
		
		int vColIndex = 0;
		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 200;
		col.setPreferredWidth(width);
		
	}
	//시원정보 입력
	private int insertAction() {
		
		ManagerAddStaffDao dao = new ManagerAddStaffDao(Integer.parseInt(tfStaffId.getText()),tfStaffName.getText(), String.valueOf(pwfPassword.getPassword()),tfPhone.getText(),Integer.parseInt(tfHourlyWage.getText()));
		
		return dao.insertArcion();
	}
	//등록시 빈칸 체크
	private int insertFieldCheck() {
		int i = 0;
		String message = "";
		if(tfStaffId.getText().trim().length() == 0) {
			i++;
			message = "사번을";
			tfStaffId.requestFocus();
		}
		if(tfStaffName.getText().trim().length() == 0) {
			i++;
			message = "이름를";
			tfStaffName.requestFocus();
		}
		
		if(tfPhone.getText().trim().length() == 0) {
			i++;
			message = "전화번호을";
			tfPhone.requestFocus();
		}
		if(tfHourlyWage.getText().trim().length() == 0) {
			i++;
			message = "시급을";
			tfHourlyWage.requestFocus();
		}
		if(pwfPassword.getPassword().length == 0) {
			i++;
			message = "비밀번호를";
			pwfPassword.requestFocus();
		}

		if(i>0) {
			JOptionPane.showMessageDialog(null, message + "확인하세요!");
		}
		return i;
	}
	//사원정보 삭제
	private Boolean deleteAction() {
		
		int custid = Integer.parseInt(tfStaffId.getText());
		
		ManagerAddStaffDao dao = new ManagerAddStaffDao();
		boolean check = dao.deleteAction(custid);
		
		return check;
	}
	private void clearColumn() {
		tfStaffId.setText("");
		tfStaffName.setText("");
		tfPhone.setText("");
		tfHourlyWage.setText("");
		pwfPassword.setText("");
		pwfReconfirm.setText("");
	}
	private void conditionQuery() {
		
		int i = comboBox.getSelectedIndex();
		String conditionQueryColumn = "";
		switch(i) {
		case 0:
			conditionQueryColumn = "staffid";
			break;
		case 1:
			conditionQueryColumn = "staffname";
			break;
		case 2:
			conditionQueryColumn = "staffphone";
			break;
		default:
			break;
		}
		tableInit();
		clearColumn();
		conditionQueryAction(conditionQueryColumn);
	}
	
	private void conditionQueryAction(String conditionQueryColumn) {
		
		ManagerAddStaffDao dao = new ManagerAddStaffDao(conditionQueryColumn, tfSearch.getText());
		ArrayList<StaffDto> dtoList = dao.conditionList();
		
		int listCount = dtoList.size();
		
		for(int index=0; index<listCount; index++) {
			String temp = Integer.toString(dtoList.get(index).getStaffid());
			String[] qTxt = {temp, dtoList.get(index).getStaffname(), dtoList.get(index).getStaffphone(),dtoList.get(index).getStaffinitdate()};
			Outer_Table.addRow(qTxt);
			
		}
	}
	
	private void tableClick() {
		int i = Inner_Table.getSelectedRow();
		String wkSequence = (String) Inner_Table.getValueAt(i, 0);
		ManagerAddStaffDao dao = new ManagerAddStaffDao(Integer.parseInt(wkSequence));
		
		StaffDto dto = dao.tableClick();
		
		tfStaffId.setText(Integer.toString(dto.getStaffid()));
		tfStaffName.setText(dto.getStaffname());
		tfPhone.setText(dto.getStaffphone());
		
	}
	
	private boolean pwCheck() {
		String pw = null;
		String pwC = null;
		for (int i = 0; i < pwfPassword.getPassword().length; i++) {
			pw += pwfPassword.getPassword()[i];
		}
		for (int i = 0; i < pwfReconfirm.getPassword().length; i++) {
			pwC += pwfReconfirm.getPassword()[i];
		}
		if (pw.equals(pwC) == true) {
			checkPassword = true;
			return true;
		} else {
			checkPassword = false;
			return false;
		}
	}
	
	private void staffIdCheck() {
		ManagerAddStaffDao dao = new ManagerAddStaffDao();
		boolean check;
		check = dao.idCheck(tfStaffId.getText());
		if (check == false) {
			JOptionPane.showMessageDialog(null, "ID가 중복되었습니다.");
			tfStaffId.setText("");
		} else {
			JOptionPane.showMessageDialog(null, "생성가능한 ID입니다.");
			checkRegister = true;
		}
	}

	
}
