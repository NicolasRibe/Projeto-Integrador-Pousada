package pousadaYpua.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pousadaYpua.DAO.ClientesDao;
import pousadaYpua.DAO.ReservasDao;
import pousadaYpua.model.Clientes;
import pousadaYpua.model.Quarto;
import pousadaYpua.model.Reserva;

public class ReservaQuarto extends JInternalFrame {

	private static final long serialVersionUID = 1L;
Clientes clientes;
Quarto quarto;
Reserva reserva;
private JTextField textDataEntrada;
private JTextField textDataSaida;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservaQuarto frame = new ReservaQuarto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReservaQuarto() {
		ClientesDao clienteDao = new ClientesDao();
		ReservasDao reservaDao = new ReservasDao();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(0, 0, 1125, 675);
	    JComponent contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	    
	    JPanel panel = new JPanel();
	    panel.setBackground(new Color(113, 177, 187));
	    panel.setBounds(0, 17, 1053, 618);
	    
	    contentPane.add(panel);
	    panel.setLayout(null);
		
		
		JTextField textCpf = new JTextField();
		textCpf.setBounds(380, 76, 263, 30);
		panel.add(textCpf);
		textCpf.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Status da Reserva:");
		lblNewLabel_6.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_6.setBounds(745, 481, 153, 30);
		panel.add(lblNewLabel_6);
		
		JTextField textStatus = new JTextField();
		textStatus.setBounds(908, 481, 135, 30);
		panel.add(textStatus);
		textStatus.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Preferências Especiais:");
		lblNewLabel_7.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_7.setBounds(380, 381, 244, 30);
		panel.add(lblNewLabel_7);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(380, 411, 328, 111);
		panel.add(textArea);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblCpf.setBounds(380, 41, 183, 30);
		panel.add(lblCpf);
		
		JLabel lblInfo = new JLabel("INFORMAÇÕES DO CLIENTE");
		lblInfo.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblInfo.setBounds(10, 41, 229, 30);
		panel.add(lblInfo);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(526, 110, 117, 29);
		panel.add(btnBuscar);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setBounds(10, 83, 229, 150);
		panel.add(txtArea);
		
		JComboBox comboBoxQuarto = new JComboBox();
		comboBoxQuarto.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"}));
		comboBoxQuarto.setMaximumRowCount(12);
		comboBoxQuarto.setBounds(380, 170, 122, 27);
		panel.add(comboBoxQuarto);
		
		JLabel lblNQuarto = new JLabel("NUMERO DO QUARTO");
		lblNQuarto.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblNQuarto.setBounds(380, 134, 183, 30);
		panel.add(lblNQuarto);
		
		textDataEntrada = new JTextField();
		textDataEntrada.setColumns(10);
		textDataEntrada.setBounds(380, 235, 122, 30);
		panel.add(textDataEntrada);
		
		textDataSaida = new JTextField();
		textDataSaida.setColumns(10);
		textDataSaida.setBounds(550, 235, 130, 30);
		panel.add(textDataSaida);
		
		JLabel lblDataEntrada = new JLabel("DATA ENTRADA");
		lblDataEntrada.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblDataEntrada.setBounds(380, 209, 183, 30);
		panel.add(lblDataEntrada);
		
		JLabel lblDataSaida = new JLabel("DATA SAIDA");
		lblDataSaida.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblDataSaida.setBounds(550, 209, 183, 30);
		panel.add(lblDataSaida);
		
		JButton btnReservar = new JButton("RESERVAR");
	
		btnReservar.setBounds(563, 290, 117, 29);
		panel.add(btnReservar);
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String cpf = textCpf.getText();
				

				clientes = new Clientes(cpf);
				clientes = clienteDao.buscar(clientes);
				textArea.setText(clientes.getInfo());
				System.out.println(clientes.getCpf() + clientes.getNome());
			}
		});
		
		comboBoxQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String numero = (String) comboBoxQuarto.getSelectedItem();
				 
				  quarto = new Quarto(numero);
				  
				  System.out.println(numero);
			}
		});
		
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				String dataEntrada = textDataEntrada.getText();
				String dataSaida = textDataSaida.getText();
				String numero = quarto.getNumero();
				
				String cpf = textCpf.getText();
				reserva = new Reserva(dataEntrada, dataSaida);
				quarto = new Quarto(numero);
				clientes = new Clientes(cpf); 
				clientes = clienteDao.buscar(clientes);
				
				reservaDao.insert(clientes, reserva, quarto);
				
			}
		});
	}
}
