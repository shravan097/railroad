import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MakeResUI extends JPanel {
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtPassword;
	private JTextField txtCity;
	private JTextField txtCC;
	private JTextField txtZip;

	/**
	 * Create the panel.
	 */
	public MakeResUI() {
		setLayout(null);
		
		// PASSENGER INFORMATION
		JLabel lblEnterPassengerInf = new JLabel("Enter Passenger Info:");
		lblEnterPassengerInf.setBounds(17, 26, 195, 16);
		add(lblEnterPassengerInf);
		
		//FIRST NAME
		txtFirstName = new JTextField();
		txtFirstName.setText("FIRST NAME");
		txtFirstName.setBounds(17, 48, 205, 26);
		add(txtFirstName);
		txtFirstName.setColumns(10);
		
		//LAST NAME
		txtLastName = new JTextField();
		txtLastName.setText("LAST NAME");
		txtLastName.setColumns(10);
		txtLastName.setBounds(17, 81, 205, 26);
		add(txtLastName);
		
		//STREET
		txtPassword = new JTextField();
		txtPassword.setText("STREET");
		txtPassword.setColumns(10);
		txtPassword.setBounds(17, 115, 205, 26);
		add(txtPassword);
		
		//CITY
		txtCity = new JTextField();
		txtCity.setText("CITY");
		txtCity.setColumns(10);
		txtCity.setBounds(17, 146, 93, 26);
		add(txtCity);
		
		//ZIP
		txtZip = new JTextField();
		txtZip.setText("ZIP");
		txtZip.setColumns(10);
		txtZip.setBounds(119, 146, 93, 26);
		add(txtZip);
		
		
		JLabel lblState = new JLabel("STATE:");
		lblState.setBounds(17, 173, 61, 16);
		add(lblState);
		
		//STATE
		final String[] states = new String[]{
		        "Alabama", "Alaska", "Arizona", "Arkansas", "California",
		        "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
		        "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
		        "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
		        "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana",
		        "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
		        "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma",
		        "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
		        "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia",
		        "Wisconsin", "Wyoming"
		    };
		JComboBox selectState = new JComboBox(states);
		selectState.setBounds(17, 192, 93, 27);
		add(selectState);
		
	
		//SELECT CREDIT CARD 
		final String[] cards = new String[] { "AMEX", "VISA", "DISCOVER", "MASTERCARD"};
		JComboBox selectCredit = new JComboBox(cards);
		selectCredit.setBounds(17, 241, 195, 27);
		add(selectCredit);
		
		//CREDIT CARD NUMBER
		txtCC = new JTextField();
		txtCC.setBounds(17, 296, 205, 26);
		add(txtCC);
		txtCC.setColumns(10);
		
		//DISPLAY TICKET INFORMATION HERE INCLUDING SEAT ASSIGNMENT
		JTextPane textPane = new JTextPane();
		textPane.setBounds(234, 55, 303, 219);
		add(textPane);
		
		JLabel lblTripInformation = new JLabel("Trip Information");
		lblTripInformation.setBounds(336, 26, 107, 16);
		add(lblTripInformation);
		
		//Confirm Reservation-- displays dialog box with seat assignments
		JButton btnConfirm = new JButton("Confirm Reservation");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "RESERVATION CONFIRMED!");
			}
		});
		btnConfirm.setBounds(244, 296, 293, 29);
		add(btnConfirm);
		
	
		JLabel lblCreditCardType = new JLabel("CREDIT CARD TYPE");
		lblCreditCardType.setBounds(17, 225, 165, 16);
		add(lblCreditCardType);
		
		JLabel lblCreditCardNumber = new JLabel("CREDIT CARD NUMBER:");
		lblCreditCardNumber.setBounds(17, 280, 165, 16);
		add(lblCreditCardNumber);

	}
}