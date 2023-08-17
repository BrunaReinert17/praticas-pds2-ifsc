package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.AnimalDAO;
import modelo.Animal;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroAnimal extends JFrame {

	private JPanel contentPane;
	private JTextField txtMarca;
	private JTextField txtEspecie;
	private JLabel lblEspecie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAnimal frame = new TelaCadastroAnimal();
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
	public TelaCadastroAnimal() {
		setTitle("Cadastrar Animal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(106, 74, 46, 14);
		contentPane.add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(253, 71, 86, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String marca = txtMarca.getText();
				String especie = txtEspecie.getText();
				
				Animal a = new Animal();
				a.setMarca(marca);
				a.setEspecie(especie);
				AnimalDAO dao = new AnimalDAO();
				dao.inserir(a);
			}
		});
		btnCadastrar.setBounds(173, 149, 99, 23);
		contentPane.add(btnCadastrar);
		
		txtEspecie = new JTextField();
		txtEspecie.setColumns(10);
		txtEspecie.setBounds(253, 118, 86, 20);
		contentPane.add(txtEspecie);
		
		lblEspecie = new JLabel("Espécie");
		lblEspecie.setBounds(106, 121, 46, 14);
		contentPane.add(lblEspecie);
	}
}