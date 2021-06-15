package jdbcproject1;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DataThrift {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataThrift window = new DataThrift();
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
	public DataThrift() {
		initialize();
		Connect();
		table_load();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	private JTextField txtnama;
	private JTextField txtmodel;
	private JTextField txtukuran;
	private JTextField txtwarna;
	private JTextField txtbrand;
	private JTextField txtkondisi;
	private JTextField txtbeli;
	private JTextField txtjual;
	private JTextField txtsupplier;
	private JTable table;
	private JTextField txtkode2;
	
	public void Connect()
	{
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thrifting", "Juditha", "testjdbc");
		}
		catch (ClassNotFoundException ex)
		{
		
		}
		catch (SQLException ex)
		{
				
	    }
				
	}
	
	public void table_load()
	{
		try
		{
			pst = con.prepareStatement("select * from pakaian");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 808, 656);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thrift Shop");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(353, 25, 133, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Input New Stuff", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(54, 85, 669, 218);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblnama = new JLabel("Nama Pakaian");
		lblnama.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblnama.setBounds(10, 32, 94, 15);
		panel.add(lblnama);
		
		JLabel lblukuran = new JLabel("Ukuran");
		lblukuran.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblukuran.setBounds(10, 113, 62, 15);
		panel.add(lblukuran);
		
		JLabel lblmodel = new JLabel("Model");
		lblmodel.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblmodel.setBounds(10, 71, 62, 15);
		panel.add(lblmodel);
		
		txtnama = new JTextField();
		txtnama.setBounds(114, 27, 183, 20);
		panel.add(txtnama);
		txtnama.setColumns(10);
		
		txtmodel = new JTextField();
		txtmodel.setColumns(10);
		txtmodel.setBounds(114, 66, 183, 20);
		panel.add(txtmodel);
		
		txtukuran = new JTextField();
		txtukuran.setColumns(10);
		txtukuran.setBounds(114, 108, 183, 20);
		panel.add(txtukuran);
		
		txtwarna = new JTextField();
		txtwarna.setColumns(10);
		txtwarna.setBounds(114, 149, 183, 20);
		panel.add(txtwarna);
		
		JLabel lblwarna = new JLabel("Warna");
		lblwarna.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblwarna.setBounds(10, 152, 62, 15);
		panel.add(lblwarna);
		
		JLabel lblbrand = new JLabel("Labelbrand");
		lblbrand.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblbrand.setBounds(10, 191, 94, 15);
		panel.add(lblbrand);
		
		JLabel lblkondisi = new JLabel("Kondisi");
		lblkondisi.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblkondisi.setBounds(356, 32, 62, 15);
		panel.add(lblkondisi);
		
		JLabel lblhargabeli = new JLabel("Harga Beli");
		lblhargabeli.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblhargabeli.setBounds(356, 71, 78, 15);
		panel.add(lblhargabeli);
		
		JLabel lblhargajual = new JLabel("Harga Jual");
		lblhargajual.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblhargajual.setBounds(356, 111, 78, 15);
		panel.add(lblhargajual);
		
		JLabel lblsupplier = new JLabel("Supplier");
		lblsupplier.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblsupplier.setBounds(356, 154, 78, 15);
		panel.add(lblsupplier);
		
		txtbrand = new JTextField();
		txtbrand.setColumns(10);
		txtbrand.setBounds(114, 186, 183, 20);
		panel.add(txtbrand);
		
		txtkondisi = new JTextField();
		txtkondisi.setColumns(10);
		txtkondisi.setBounds(451, 27, 183, 20);
		panel.add(txtkondisi);
		
		txtbeli = new JTextField();
		txtbeli.setColumns(10);
		txtbeli.setBounds(451, 66, 183, 20);
		panel.add(txtbeli);
		
		txtjual = new JTextField();
		txtjual.setColumns(10);
		txtjual.setBounds(451, 108, 183, 20);
		panel.add(txtjual);
		
		txtsupplier = new JTextField();
		txtsupplier.setColumns(10);
		txtsupplier.setBounds(451, 149, 183, 20);
		panel.add(txtsupplier);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 432, 711, 159);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnclear = new JButton("clear");
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtnama.setText("");
				txtmodel.setText("");
				txtukuran.setText("");
				txtwarna.setText("");
				txtbrand.setText("");
				txtkondisi.setText("");
				txtbeli.setText("");
				txtjual.setText("");
				txtsupplier.setText("");
				
			}
		});
		btnclear.setBounds(327, 314, 98, 35);
		frame.getContentPane().add(btnclear);
		
		JButton btnsave = new JButton("save");
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String lblnama, lblmodel, lblukuran, lblwarna, lblbrand, lblkondisi, lblbeli, lbljual, lblsupplier;
				
				lblnama = txtnama.getText();
				lblmodel = txtmodel.getText();
				lblukuran = txtukuran.getText();
				lblwarna = txtwarna.getText();
				lblbrand = txtbrand.getText();
				lblkondisi = txtkondisi.getText();
				lblbeli = txtbeli.getText();
				lbljual = txtjual.getText();
				lblsupplier = txtsupplier.getText();
				try {
					pst = con.prepareStatement("insert into pakaian(nama_pk,model_pk,ukuran_pk,warna_pk,labelbrand,kondisi,harga_beli,harga_jual,supplier)values(?,?,?,?,?,?,?,?,?)");
					pst.setString(1, lblnama);
					pst.setString(2, lblmodel);
					pst.setString(3, lblukuran);
					pst.setString(4, lblwarna);
					pst.setString(5, lblbrand);
					pst.setString(6, lblkondisi);
					pst.setString(7, lblbeli);
					pst.setString(8, lbljual);
					pst.setString(9, lblsupplier);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "CLOTHES SUCCESS ADDED ^_^");
					table_load();
					
					txtnama.setText("");
					txtmodel.setText("");
					txtukuran.setText("");
					txtwarna.setText("");
					txtbrand.setText("");
					txtkondisi.setText("");
					txtbeli.setText("");
					txtjual.setText("");
					txtsupplier.setText("");
					txtnama.requestFocus();
					}
				
				    catch (SQLException el) {
				    	
				    	el.printStackTrace();
				    }
			
				
			}
		});
		btnsave.setBounds(167, 314, 98, 35);
		frame.getContentPane().add(btnsave);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String lblnama, lblmodel, lblukuran, lblwarna, lblbrand, lblkondisi, lblbeli, lbljual, lblsupplier, lblkode2;
				
				lblnama = txtnama.getText();
				lblmodel = txtmodel.getText();
				lblukuran = txtukuran.getText();
				lblwarna = txtwarna.getText();
				lblbrand = txtbrand.getText();
				lblkondisi = txtkondisi.getText();
				lblbeli = txtbeli.getText();
				lbljual = txtjual.getText();
				lblsupplier = txtsupplier.getText();
				lblkode2 = txtkode2.getText();
				
				try {
					pst = con.prepareStatement("update pakaian set nama_pk= ?,model_pk= ?,ukuran_pk= ?,warna_pk= ?,labelbrand= ?,kondisi= ?,harga_beli= ?,harga_jual= ?,supplier= ? where kode_pk= ?");
					pst.setString(1, lblnama);
					pst.setString(2, lblmodel);
					pst.setString(3, lblukuran);
					pst.setString(4, lblwarna);
					pst.setString(5, lblbrand);
					pst.setString(6, lblkondisi);
					pst.setString(7, lblbeli);
					pst.setString(8, lbljual);
					pst.setString(9, lblsupplier);
					pst.setString(10, lblkode2);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "UPDATE SUCCESS ^_^");
					table_load();
					
					txtnama.setText("");
					txtmodel.setText("");
					txtukuran.setText("");
					txtwarna.setText("");
					txtbrand.setText("");
					txtkondisi.setText("");
					txtbeli.setText("");
					txtjual.setText("");
					txtsupplier.setText("");
					txtnama.requestFocus();
					}
				
				    catch (SQLException el) {
				    	
				    	el.printStackTrace();
				    }
				
				
				
				
			}
		});
		btnUpdate.setBounds(500, 370, 98, 35);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String lblkode2;
				
				lblkode2 = txtkode2.getText();
				
				try {
					pst = con.prepareStatement("delete from pakaian where kode_pk= ?");

					pst.setString(1, lblkode2);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "This data has been successfully deleted :(");
					table_load();
					
					txtnama.setText("");
					txtmodel.setText("");
					txtukuran.setText("");
					txtwarna.setText("");
					txtbrand.setText("");
					txtkondisi.setText("");
					txtbeli.setText("");
					txtjual.setText("");
					txtsupplier.setText("");
					txtnama.requestFocus();
					}
				
				    catch (SQLException el) {
				    	
				    	el.printStackTrace();
				    }
				
				
				
				
				
				
			}
		});
		btnDelete.setBounds(626, 370, 98, 35);
		frame.getContentPane().add(btnDelete);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(52, 359, 417, 62);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtkode2 = new JTextField();
		txtkode2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					
					String kode_pk = txtkode2.getText();
				
					pst = con.prepareStatement("select nama_pk,model_pk,ukuran_pk,warna_pk,labelbrand,kondisi,harga_beli,harga_jual,supplier from pakaian where kode_pk = ?;");
					pst.setString(1, kode_pk);
					ResultSet rs = pst.executeQuery();
				  
					if (rs.next()==true)
					{
						String nama_pk = rs.getString(1);
						String model_pk = rs.getString(2);
						String ukuran_pk = rs.getString(3);
						String warna_pk = rs.getString(4);
						String labelbrand = rs.getString(5);
						String kondisi = rs.getString(6);
						String harga_beli = rs.getString(7);
						String harga_jual = rs.getString(8);
						String supplier = rs.getString(9);
					
						txtnama.setText(nama_pk);
						txtmodel.setText(model_pk);
						txtukuran.setText(ukuran_pk);
						txtwarna.setText(warna_pk);
						txtbrand.setText(labelbrand);
						txtkondisi.setText(kondisi);
						txtbeli.setText(harga_beli);
						txtjual.setText(harga_jual);
						txtsupplier.setText(supplier);
					}
					else
					{
						txtnama.setText("");
						txtmodel.setText("");
						txtukuran.setText("");
						txtwarna.setText("");
						txtbrand.setText("");
						txtkondisi.setText("");
						txtbeli.setText("");
						txtjual.setText("");
						txtsupplier.setText("");
					}
					
			}
			
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			
			
			}
		});
		txtkode2.setColumns(10);
		txtkode2.setBounds(129, 22, 183, 20);
		panel_1.add(txtkode2);
		
		JLabel lblkode2 = new JLabel("Kode Pakaian");
		lblkode2.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblkode2.setBounds(25, 27, 94, 15);
		panel_1.add(lblkode2);
		
	}
}
