import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LookupResUI extends JPanel {
	private JTextField txtPassengerID;
	private JTextField txtReservationID;


	/**
	 * Create the panel.
	 */
	public LookupResUI() {
		setLayout(null);

		JLabel lblLookUpA = new JLabel("Look Up A Reservation");
		lblLookUpA.setBounds(34, 28, 162, 16);
		add(lblLookUpA);
		
		
		JLabel lblSearchByPassenger = new JLabel("Search by Passenger ID:");
		lblSearchByPassenger.setBounds(24, 66, 155, 16);
		add(lblSearchByPassenger);
		
		//SEARCH BY PASSENGER ID
		txtPassengerID = new JTextField();
		txtPassengerID.setBounds(34, 87, 177, 26);
		add(txtPassengerID);
		txtPassengerID.setColumns(10);
		
		JLabel lblSearchByReservation = new JLabel("Search by Reservation ID");
		lblSearchByReservation.setBounds(24, 125, 155, 16);
		add(lblSearchByReservation);
		
		//SEARCH BY RESERVATION ID
		txtReservationID = new JTextField();
		txtReservationID.setColumns(10);
		txtReservationID.setBounds(34, 146, 177, 26);
		add(txtReservationID);
		
		
		JLabel lblFoundResults = new JLabel("Reservations Found");
		lblFoundResults.setBounds(305, 28, 123, 16);
		add(lblFoundResults);
		
		//RESULTS PULLED FROM DATABASE
		DefaultListModel<String> myList = new DefaultListModel<>();
		JList results = new JList(myList);
		results.setBounds(234, 56, 267, 233);
		add(results);
		
		
		
		//SEARCH BUTTON
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(24, 184, 187, 29);
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ReservationQuery rq = new ReservationQuery();
				System.out.println(txtPassengerID.getText());
				if(!(txtPassengerID.getText().isEmpty()) && txtReservationID.getText().isEmpty())
				{
					Reservation i  = rq.getReservationByPerson_Id(Integer.parseInt(txtPassengerID.getText()));
					myList.clear();
					myList.addElement(String.format("Reservation ID: %d",i.getReservation_id()));
					myList.addElement(String.format("Reservation Date: %s",i.getReservation_date()));
					myList.addElement(String.format("Passenger ID: %d",i.getPaying_passenger_id()));

					revalidate();
					repaint();

				}

				if(txtPassengerID.getText().isEmpty() && !(txtReservationID.getText().isEmpty()))
				{

					Reservation i  = rq.getReservationByReservation_Id(Integer.parseInt(txtReservationID.getText()));
					myList.clear();
					myList.addElement(String.format("Reservation ID: %d",i.getReservation_id()));
					myList.addElement(String.format("Reservation Date: %s",i.getReservation_date()));
					myList.addElement(String.format("Passenger ID: %d",i.getPaying_passenger_id()));
					revalidate();
					repaint();

				}
			}
		});
		add(btnSearch);
		
		//CHANGE RESERVATION BUTTON
		JButton btnChange = new JButton("Change Reservation");
		btnChange.setBounds(24, 240, 187, 29);
		add(btnChange);
		
		//CANCEL RESERVATION BUTTON
		JButton btnCancel = new JButton("Cancel Reservation");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    JOptionPane.showMessageDialog(null, "Reservation canceled!.");

			}
		});
		btnCancel.setBounds(24, 270, 187, 29);
		add(btnCancel);
		
		//CLEAR SELECTION BUTTON
		JButton btnClear = new JButton("Clear Selection");
		btnClear.setBounds(287, 294, 155, 29);
		add(btnClear);

	}
}
