import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class CustomJFrame extends JFrame{

	private JLabel headingLabel = new JLabel("Personal Information");
	private JLabel firstNameLabel = new JLabel("First Name: ");
	private JLabel lastNameLabel = new JLabel("Last Name: ");
	private JLabel phoneNumberLabel = new JLabel("Phone Number: ");
	private JLabel emailLabel = new JLabel("Email: ");
	private JLabel dietaryLabel = new JLabel("Dietary Questions");
	private JLabel genderLabel = new JLabel("Gender: ");
	private JLabel waterLabel = new JLabel("How many cups of water on average do you drink a day?");
	private JLabel mealsLabel = new JLabel("How many meals on average do you eat a day?");
	private JLabel checkBoxLabel = new JLabel("Do any of these meals regularly contain: ");
	private JLabel walkLabel = new JLabel("On average how many miles do you walk in a day?");
	private JLabel weightLabel = new JLabel("How much do you weigh?");
	private JTextField firstNameTextField = new JTextField();
	private JTextField lastNameTextField = new JTextField();
	private JTextField phoneNumberTextField = new JTextField();
	private JTextField emailTextField = new JTextField();
	private JRadioButton maleRadioButton = new JRadioButton("Male");
	private JRadioButton femaleRadioButton = new JRadioButton("Female");
	private JRadioButton preferRadioButton = new JRadioButton("Prefer no to sau");
	private ButtonGroup radioButtonGroup = new ButtonGroup(); 
	private SpinnerNumberModel spinnerModel= new SpinnerNumberModel(15,0,50,1);
	private JSpinner waterIntakeSpinner = new JSpinner(spinnerModel);
	private JSlider mealSlider = new JSlider(SwingConstants.HORIZONTAL, 1,10,3);
	private JCheckBox wheatCheckBox = new JCheckBox("Wheat");
	private JCheckBox sugarCheckBox = new JCheckBox("Sugar");
	private JCheckBox dairyCheckBox = new JCheckBox("Dairy");
	private String[] walkOptions = {"Less than 1 Mile","More than 1 mile but less than 2 miles","More than 2 miles but less than 3 miles","More than 3 miles"};
	private JComboBox<String> walkComboBox = new JComboBox<String>(walkOptions);
	private JFormattedTextField weightFormattedTextField = new JFormattedTextField(NumberFormat.getIntegerInstance());;
	private JButton clearButton = new JButton("Clear");
	private JButton submitButton = new JButton("Submit");
	private FileHandler fileHandler = new FileHandler();


	public CustomJFrame() {
		JFrame frame = new JFrame();
		frame.setSize(400,900);
		frame.setTitle("Dietary Survey");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());
		GridBagConstraints layoutManager = new GridBagConstraints();
		layoutManager.insets = new Insets(10, 0, 10, 0);

		//Header
		layoutManager.gridx = 0;
		layoutManager.gridy = 0;

		frame.add(headingLabel,layoutManager);

		//First Name
		layoutManager.gridx = 0;
		layoutManager.gridy = 1;
		firstNameTextField.setColumns(20);
		firstNameTextField.setEditable(true);


		//Last Name
		layoutManager.gridx = 0;
		layoutManager.gridy = 2;
		lastNameTextField.setColumns(20);
		lastNameTextField.setEditable(true);


		//Phone Number
		layoutManager.gridx = 0;
		layoutManager.gridy = 3;
		phoneNumberTextField.setColumns(20);
		phoneNumberTextField.setEditable(true);


		//Email
		layoutManager.gridx = 0;
		layoutManager.gridy = 4;
		emailTextField.setColumns(20);
		emailTextField.setEditable(true);

		//Labels Panel 
		JPanel labelsPanel = new JPanel();
		labelsPanel.setLayout(new GridBagLayout());
		GridBagConstraints panelGrid = new GridBagConstraints();
		panelGrid.insets = new Insets(10,0,10,0);
		panelGrid.gridx = 0;
		panelGrid.gridy = 0;
		labelsPanel.add(firstNameLabel,panelGrid);
		panelGrid.gridy = 1;
		labelsPanel.add(lastNameLabel,panelGrid);
		panelGrid.gridy = 2;
		labelsPanel.add(phoneNumberLabel,panelGrid);
		panelGrid.gridy = 3;
		labelsPanel.add(emailLabel,panelGrid);
		layoutManager.gridx = 0;
		layoutManager.gridy = 1;
		frame.add(labelsPanel,layoutManager);

		//TextFields Panel
		JPanel textFieldsPanel = new JPanel();
		textFieldsPanel.setLayout(new GridBagLayout());
		panelGrid.gridx = 0;
		panelGrid.gridy = 0;
		textFieldsPanel.add(firstNameTextField, panelGrid);
		panelGrid.gridy = 1;
		textFieldsPanel.add(lastNameTextField, panelGrid);
		panelGrid.gridy = 2;
		textFieldsPanel.add(phoneNumberTextField, panelGrid);
		panelGrid.gridy = 3;
		textFieldsPanel.add(emailTextField, panelGrid);
		layoutManager.gridx = 0;
		layoutManager.gridy = 1;
		//frame.add(textFieldsPanel,layoutManager);

		//Puts the panels in a panel for better formatting
		JPanel panelPanel = new JPanel();
		panelPanel.setLayout(new BorderLayout());
		panelPanel.add(labelsPanel, BorderLayout.WEST);
		panelPanel.add(textFieldsPanel, BorderLayout.EAST);
		frame.add(panelPanel,layoutManager);


		//Gender
		//Radio button group
		radioButtonGroup.add(maleRadioButton);
		radioButtonGroup.add(femaleRadioButton);
		radioButtonGroup.add(preferRadioButton);
		//Sets default and names for buttons
		maleRadioButton.setActionCommand("Male");
		femaleRadioButton.setActionCommand("Female");
		preferRadioButton.setActionCommand("Prefer not to say");
		//Adds Buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4,1));
		buttonPanel.add(genderLabel);
		buttonPanel.add(maleRadioButton);	
		buttonPanel.add(femaleRadioButton);
		buttonPanel.add(preferRadioButton);
		layoutManager.gridx = 0;
		layoutManager.gridy = 5;
		frame.add(buttonPanel ,layoutManager);

		//Dietary Label
		layoutManager.gridx = 0;
		layoutManager.gridy = 8;
		frame.add(dietaryLabel,layoutManager);

		//Water
		layoutManager.gridx = 0;
		layoutManager.gridy = 9;
		frame.add(waterLabel,layoutManager);
		layoutManager.gridy = 10;
		frame.add(waterIntakeSpinner, layoutManager);

		//Meals
		layoutManager.gridx = 0;
		layoutManager.gridy = 11;
		frame.add(mealsLabel,layoutManager);
		mealSlider.setMajorTickSpacing(1);
		mealSlider.setPaintLabels(true);
		mealSlider.setPaintTicks(true);
		layoutManager.gridy = 12;
		frame.add(mealSlider,layoutManager);


		//Check Box
		layoutManager.gridx = 0;
		layoutManager.gridy = 13;
		frame.add(checkBoxLabel,layoutManager);
		JPanel checkBoxPanel = new JPanel();
		checkBoxPanel.add(dairyCheckBox);
		checkBoxPanel.add(wheatCheckBox);
		checkBoxPanel.add(sugarCheckBox);
		layoutManager.gridy = 14;
		frame.add(checkBoxPanel, layoutManager);

		//Walk
		layoutManager.gridx = 0;
		layoutManager.gridy = 15;
		frame.add(walkLabel,layoutManager);
		layoutManager.gridy = 16;
		frame.add(walkComboBox,layoutManager);

		//Weight
		layoutManager.gridx = 0;
		layoutManager.gridy = 17;
		frame.add(weightLabel, layoutManager);
		weightFormattedTextField.setColumns(20);
		weightFormattedTextField.setEditable(true);
		layoutManager.gridy = 18;
		frame.add(weightFormattedTextField, layoutManager);

		//Clear and Submit buttons
		InnerActionListener listener = new InnerActionListener();
		clearButton.setName("clear");
		clearButton.addActionListener(listener);
		clearButton.setBackground(Color.YELLOW);
		submitButton.setName("submit");
		submitButton.addActionListener(listener);
		submitButton.setBackground(Color.GREEN);
		//clearButton.actionPerformed(mouse_clicked);

		//Clear and Submit Panel
		JPanel clearAndSubmit = new JPanel();
		clearAndSubmit.add(clearButton);
		clearAndSubmit.add(submitButton);
		layoutManager.gridy = 19;
		frame.add(clearAndSubmit,layoutManager);



		frame.setVisible(true);
	}//END CustomeJFrame Constructor

	/**
	 * Inner class
	 * Listens for click presses
	 * implements ActionListener
	 */
	class InnerActionListener implements ActionListener{

		/**
		 * Checks when clear and submit have been press
		 * Takes all the inputed fields 
		 * Then sends them to FileHandler to be written in to the CSV file
		 * @param AccountEvent button press
		 */
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();//Listens for button press

			String name = button.getName();//Checks which button was pressed
			
			//If block to set submit or clear
			if(name.equals("submit")){
				//try>catch for gender radioButtonGroup would crash it after clearing and submitting a null value
				try {
					System.out.println("Submit clicked");
					SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
					Date date = new Date();
					String formatedDate = dateFormat.format(date).toString();
					String first = firstNameTextField.getText();
					String last = lastNameTextField.getText();
					String phone = phoneNumberTextField.getText();
					String email = emailTextField.getText();
					int water = (int) waterIntakeSpinner.getValue();
					int meal = mealSlider.getValue();
					boolean dairy = dairyCheckBox.isSelected();
					boolean wheat = wheatCheckBox.isSelected();
					boolean sugar = sugarCheckBox.isSelected();
					String walk = walkOptions[walkComboBox.getSelectedIndex()];
					String weight = weightFormattedTextField.getText();
					String gender = radioButtonGroup.getSelection().getActionCommand();
					
					clearForm();
					
					fileHandler.writeResults(formatedDate + "," + first + "," + last + "," + phone + "," + email + ","+ gender + "," + water + "," + meal + "," + dairy + "," + wheat + "," + sugar + "," + walk + "," + weight);
				}catch(NullPointerException nullError) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
					Date date = new Date();
					String formatedDate = dateFormat.format(date).toString();
					String first = firstNameTextField.getText();
					String last = lastNameTextField.getText();
					String phone = phoneNumberTextField.getText();
					String email = emailTextField.getText();
					int water = (int) waterIntakeSpinner.getValue();
					int meal = mealSlider.getValue();
					boolean dairy = dairyCheckBox.isSelected();
					boolean wheat = wheatCheckBox.isSelected();
					boolean sugar = sugarCheckBox.isSelected();
					String walk = walkOptions[walkComboBox.getSelectedIndex()];
					String weight = weightFormattedTextField.getText();
					String gender = "null";
					
					clearForm();
					
					fileHandler.writeResults(formatedDate + "," + first + "," + last + "," + phone + "," + email + ","+ gender + "," + water + "," + meal + "," + dairy + "," + wheat + "," + sugar + "," + walk + "," + weight);
				}
			}else if(name.equals("clear")) {
				System.out.println("Clear Clicked");
				clearForm();
			}//END if

		}//END actionPerformed


		/**
		 * Resets the input fields
		 */
		private void clearForm() {
			firstNameTextField.setText("");
			lastNameTextField.setText("");
			phoneNumberTextField.setText("");
			emailTextField.setText("");
			radioButtonGroup.clearSelection();
			waterIntakeSpinner.setValue(15);
			mealSlider.setValue(3);
			dairyCheckBox.setSelected(false);
			wheatCheckBox.setSelected(false);
			sugarCheckBox.setSelected(false);
			walkComboBox.setSelectedIndex(0);
			weightFormattedTextField.setText(null);
		}//END clearForm

	}//END InnerACtionListener class
}//END CustomJFrame class

