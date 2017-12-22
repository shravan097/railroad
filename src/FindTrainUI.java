import javax.swing.*;
import java.util.List;


public class FindTrainUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public FindTrainUI() {
		setLayout(null);
		
		JComboBox setOrigin = new JComboBox();
		setOrigin.setBounds(19, 34, 207, 27);


		StationQuery station_query = new StationQuery();
		List<Station> allStation = station_query.getAllStation();
		for (Station i : allStation)
			setOrigin.addItem(i.getStation_name());
		add(setOrigin);



		
		JComboBox setDestination = new JComboBox();
		setDestination.setBounds(19, 84, 207, 27);
		for (Station i : allStation)
			setDestination.addItem(i.getStation_name());
		add(setDestination);

		// Travel Up to 10 People
		JComboBox setTravelers = new JComboBox();
		setTravelers.setBounds(19, 136, 133, 27);
		for( int i = 1; i< 11; ++i)
			setTravelers.addItem(i);
		add(setTravelers);

		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(19, 230, 207, 29);
		add(btnSearch);
		
		JLabel lblNewLabel = new JLabel("Select Origin Station");
		lblNewLabel.setBounds(22, 17, 204, 16);
		add(lblNewLabel);
		
		JLabel lblSelectDestinationStation = new JLabel("Select Destination Station");
		lblSelectDestinationStation.setBounds(22, 66, 204, 16);
		add(lblSelectDestinationStation);
		
		JLabel lblSelectTravelers = new JLabel("Select Travelers");
		lblSelectTravelers.setBounds(22, 118, 204, 16);
		add(lblSelectTravelers);
		


		JLabel lblSelectDate = new JLabel("Enter Date (YYYY-MM-DD)");
		lblSelectDate.setBounds(22, 168, 204, 16);
		add(lblSelectDate);
		JTextField date = new JTextField(10);
		date.setBounds(20,185,134,26);
		add(date);

		
		JList avail_trains = new JList();
		avail_trains.setBounds(248, 38, 232, 166);
		add(avail_trains);
		
		JLabel lblNewLabel_1 = new JLabel("Available Trains");
		lblNewLabel_1.setBounds(312, 17, 105, 16);
		add(lblNewLabel_1);
		
		JButton btnSelect = new JButton("Clear Selection");
		btnSelect.setBounds(257, 248, 207, 29);
		add(btnSelect);
		
		JButton btnClear = new JButton("Make Selection");
		btnClear.setBounds(258, 216, 207, 29);
		add(btnClear);

	}
}
