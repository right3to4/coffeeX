package com.coffeex.staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.coffeex.dto.NoticeDto;
import com.coffeex.staffdao.CheifCreateNoticeDao;
import com.coffeex.staffdao.CheifUpdateStaffDao;
import com.coffeex.staffdao.ManagerAddStaffDao;
import com.coffeex.staffdao.StaffViewNoticeDao;
import com.coffeex.util.CustomerInfo;

import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheifCreateNotice {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfTitle;
	private JEditorPane epText;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_2;
	private JTable Inner_Notice;
	private final DefaultTableModel Outer_Notice = new DefaultTableModel();
	private JTextField tfInsertDate;
	private JLabel lblNewLabel_2_1;
	private JTextField tfUpdateDate;
	private JLabel lblNewLabel_2_1_1;
	private JButton btnWriteNotice;
	private JButton btnDeleteNotice;
	private JButton btnUpdateNotice;
	private JButton btnInsertNotice;
	
	int clickNoticeName = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheifCreateNotice window = new CheifCreateNotice();
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
	public CheifCreateNotice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("공지사항 등록/수정");
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				OrderNoticeTableInit();
				searchAction();

			}
		});
		frame.setBounds(100, 100, 600, 621);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTfTitle());
		frame.getContentPane().add(getEpText());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getTfInsertDate());
		frame.getContentPane().add(getLblNewLabel_2_1());
		frame.getContentPane().add(getTfUpdateDate());
		frame.getContentPane().add(getLblNewLabel_2_1_1());
		frame.getContentPane().add(getBtnWriteNotice());
		frame.getContentPane().add(getBtnDeleteNotice());
		frame.getContentPane().add(getBtnUpdateNotice());
		frame.getContentPane().add(getBtnInsertNotice());
		frame.setDefaultCloseOperation(2);
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

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("공지사항");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			lblNewLabel_1.setBounds(31, 72, 99, 26);
		}
		return lblNewLabel_1;
	}

	private JTextField getTfTitle() {
		if (tfTitle == null) {
			tfTitle = new JTextField();
			tfTitle.setBounds(66, 221, 503, 26);
			tfTitle.setColumns(10);
		}
		return tfTitle;
	}

	private JEditorPane getEpText() {
		if (epText == null) {
			epText = new JEditorPane();
			epText.setBounds(31, 297, 538, 256);
		}
		return epText;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableClick();
				}
			});
			scrollPane.setBounds(31, 110, 538, 99);
			scrollPane.setViewportView(getInner_Notice());
		}
		return scrollPane;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("제목");
			lblNewLabel_2.setBounds(31, 226, 39, 16);
		}
		return lblNewLabel_2;
	}

	private JTable getInner_Notice() {
		if (Inner_Notice == null) {
			Inner_Notice = new JTable();
			Inner_Notice.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableClick();
				}
			});
			Inner_Notice.setShowHorizontalLines(false);
			Inner_Notice.setShowVerticalLines(false);
			Inner_Notice.setShowGrid(false);
			Inner_Notice.setModel(Outer_Notice);
		}
		return Inner_Notice;
	}

	private JTextField getTfInsertDate() {
		if (tfInsertDate == null) {
			tfInsertDate = new JTextField();
			tfInsertDate.setEnabled(false);
			tfInsertDate.setColumns(10);
			tfInsertDate.setBounds(180, 259, 166, 26);
		}
		return tfInsertDate;
	}

	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("작성일자");
			lblNewLabel_2_1.setBounds(135, 264, 63, 16);
		}
		return lblNewLabel_2_1;
	}

	private JTextField getTfUpdateDate() {
		if (tfUpdateDate == null) {
			tfUpdateDate = new JTextField();
			tfUpdateDate.setEnabled(false);
			tfUpdateDate.setColumns(10);
			tfUpdateDate.setBounds(403, 259, 166, 26);
		}
		return tfUpdateDate;
	}

	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("수정일자");
			lblNewLabel_2_1_1.setBounds(358, 264, 63, 16);
		}
		return lblNewLabel_2_1_1;
	}

	private JButton getBtnWriteNotice() {
		if (btnWriteNotice == null) {
			btnWriteNotice = new JButton("공지사항작성");
			btnWriteNotice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfTitle.setText("");
					tfInsertDate.setText("");
					tfUpdateDate.setText("");
					epText.setText("");
				}
			});
			btnWriteNotice.setBounds(452, 76, 117, 29);
		}
		return btnWriteNotice;
	}

	private JButton getBtnDeleteNotice() {
		if (btnDeleteNotice == null) {
			btnDeleteNotice = new JButton("삭제");
			btnDeleteNotice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					if (deleteAction() == true) {
						JOptionPane.showMessageDialog(null, "공지사항이 삭제 되었습니다.");
						tfTitle.setText("");
						epText.setText("");
						tfInsertDate.setText("");
						tfUpdateDate.setText("");
						OrderNoticeTableInit();
						searchAction();

					} else {
						JOptionPane.showMessageDialog(null, "DB작업중 문제가 발생했습니다. \n행정실로 문의 하세요.");
					}

				}
			});
			btnDeleteNotice.setBounds(452, 558, 117, 29);
		}
		return btnDeleteNotice;
	}

	private JButton getBtnUpdateNotice() {
		if (btnUpdateNotice == null) {
			btnUpdateNotice = new JButton("수정");
			btnUpdateNotice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateAction();
				}
			});
			btnUpdateNotice.setBounds(323, 558, 117, 29);
		}
		return btnUpdateNotice;
	}

	private JButton getBtnInsertNotice() {
		if (btnInsertNotice == null) {
			btnInsertNotice = new JButton("등록");
			btnInsertNotice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int check = 0;
					check = insertFieldCheck();  
					if(check == 0) {
						insertAction();						
					}
					
				}
			});
			btnInsertNotice.setBounds(194, 558, 117, 29);
		}
		return btnInsertNotice;
	}

	// -----------------function------------
	private void OrderNoticeTableInit() {

		Outer_Notice.addColumn("No.");
		Outer_Notice.addColumn("제목");
		Outer_Notice.addColumn("작성일자");
		Outer_Notice.addColumn("수정일자");

		Outer_Notice.setColumnCount(4);

		int i = Outer_Notice.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Notice.removeRow(0);
		}

		Inner_Notice.setAutoResizeMode(Inner_Notice.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = Inner_Notice.getColumnModel().getColumn(vColIndex);
		int width = 50;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Notice.getColumnModel().getColumn(vColIndex);
		width = 200;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Notice.getColumnModel().getColumn(vColIndex);
		width = 140;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = Inner_Notice.getColumnModel().getColumn(vColIndex);
		width = 140;
		col.setPreferredWidth(width);

	}

	private void searchAction() {

		StaffViewNoticeDao dao = new StaffViewNoticeDao();
		ArrayList<NoticeDto> dtoList = dao.NoticeselectList();

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(dtoList.get(index).getNoticeid());
			String[] qTxt = { temp, dtoList.get(index).getNoticetitle(), dtoList.get(index).getNoticeinsertdate(),
					dtoList.get(index).getNoticeupdatedate() };
			Outer_Notice.addRow(qTxt);
		}
	}

	private void tableClick() {
		int i = Inner_Notice.getSelectedRow();
		String wkNoticeid = (String) Inner_Notice.getValueAt(i, 0);

		StaffViewNoticeDao dao = new StaffViewNoticeDao(Integer.parseInt(wkNoticeid));

		NoticeDto dto = dao.tableClick();

		tfTitle.setText(dto.getNoticetitle());
		tfInsertDate.setText(dto.getNoticeinsertdate());
		tfUpdateDate.setText(dto.getNoticeupdatedate());
		epText.setText(dto.getNoticetext());
		clickNoticeName = dto.getNoticeid();
		
	}
	
	private void insertAction() {

		CheifCreateNoticeDao dao = new CheifCreateNoticeDao(CustomerInfo.staffid,tfTitle.getText(),epText.getText());
		
		tfTitle.setText("");
		epText.setText("");
		
		if(dao.insertArcion() == 1) {
			JOptionPane.showMessageDialog(null, "공지사항이 등록되었습니다.");
		}else {
			JOptionPane.showMessageDialog(null, "공지사항이 등록되지 않았습니다.\n 다시 시도해주세요.");
		}
		
	}
	
	private int insertFieldCheck() {
		int i = 0;
		String message = "";
		if (tfTitle.getText().trim().length() == 0) {
			i++;
			message = "제목을";
			tfTitle.requestFocus();
		}
		if (epText.getText().trim().length() == 0) {
			i++;
			message = "내용를";
			epText.requestFocus();
		}
		

		if (i > 0) {
			JOptionPane.showMessageDialog(null, message + "확인하세요!");
		}
		return i;
	}
	
	private void updateAction() {

		CheifCreateNoticeDao dao = new CheifCreateNoticeDao(tfTitle.getText(),epText.getText(),clickNoticeName);

		boolean ok = dao.updateAction();

		if (ok == true) {
			JOptionPane.showMessageDialog(null, "공지사항이 수정 되었습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "DB작업중 문제가 발생했습니다. \n 개발자에게 문의주세요");
		}
	}
	private Boolean deleteAction() {

		int noticeid = clickNoticeName;

		CheifCreateNoticeDao dao = new CheifCreateNoticeDao();
		boolean check = dao.deleteAction(noticeid);

		return check;
	}

}
