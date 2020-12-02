import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class InventoryMain {

	private JFrame frame;
	private JTextField SKU;
	private JTextField title;
	private JTextField price;
	private JTextField quant;
	private JTextField inqSKU;
	private JButton addBookBtn;
	private JLabel errorMsg;
	private JButton removeBtn;
	private JButton findBookBtn;
	private JButton inventoryBtn;
	
	private ArrayList<book> inventory = new ArrayList<book>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryMain window = new InventoryMain();
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
	public InventoryMain() {
		initialize();
		createEvents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Cochin", Font.PLAIN, 13));
		frame.getContentPane().setLayout(null);
		
		addBookBtn = new JButton("Add Book");
		addBookBtn.setBounds(63, 175, 117, 29);
		frame.getContentPane().add(addBookBtn);
		
		SKU = new JTextField();
		SKU.setBounds(100, 48, 130, 26);
		frame.getContentPane().add(SKU);
		SKU.setColumns(10);
		
		JLabel SKUNo = new JLabel("SKU No.");
		SKUNo.setBounds(27, 53, 61, 16);
		frame.getContentPane().add(SKUNo);
		
		JLabel Price = new JLabel("Price");
		Price.setBounds(27, 109, 61, 16);
		frame.getContentPane().add(Price);
		
		JLabel Title = new JLabel("Title");
		Title.setBounds(27, 81, 61, 16);
		frame.getContentPane().add(Title);
		
		JLabel Quantity = new JLabel("Quantity");
		Quantity.setBounds(27, 137, 61, 16);
		frame.getContentPane().add(Quantity);
		
		title = new JTextField();
		title.setBounds(100, 76, 130, 26);
		frame.getContentPane().add(title);
		title.setColumns(10);
		
		price = new JTextField();
		price.setBounds(100, 104, 130, 26);
		frame.getContentPane().add(price);
		price.setColumns(10);
		
		quant = new JTextField();
		quant.setBounds(100, 132, 130, 26);
		frame.getContentPane().add(quant);
		quant.setColumns(10);
		
		JLabel label = new JLabel("Enter SKU No.");
		label.setBounds(311, 53, 86, 16);
		frame.getContentPane().add(label);
		
		inqSKU = new JTextField();
		inqSKU.setBounds(289, 76, 130, 26);
		frame.getContentPane().add(inqSKU);
		inqSKU.setColumns(10);
		
		removeBtn = new JButton("Remove Book");
		removeBtn.setBounds(296, 105, 117, 29);
		frame.getContentPane().add(removeBtn);
		
		findBookBtn = new JButton("Find Book");
		findBookBtn.setBounds(297, 132, 117, 29);
		frame.getContentPane().add(findBookBtn);
		
		inventoryBtn = new JButton("Display Inventory");
		inventoryBtn.setBounds(289, 228, 137, 29);
		frame.getContentPane().add(inventoryBtn);
		
		JLabel lblNewLabel = new JLabel("Welcome to ivaG's bookstore");
		lblNewLabel.setBounds(149, 11, 182, 16);
		frame.getContentPane().add(lblNewLabel);
		
		errorMsg = new JLabel("");
		errorMsg.setBounds(27, 228, 203, 29);
		frame.getContentPane().add(errorMsg);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void createEvents()
	{ //method when Add Button is clicked
		addBookBtn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				addBook(); //actual method for adding the Big Numbers
			}
		});
		
		removeBtn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				removeBook(); //actual method for adding the Big Numbers
			}
		});
		
		removeBtn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				removeBook(); //actual method for adding the Big Numbers
			}
		});
		
		findBookBtn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				findBook(); //actual method for adding the Big Numbers
			}
		});
		
		inventoryBtn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				printInventory(); //actual method for adding the Big Numbers
			}
		});
	}
	
	public void addBook() {
		if (SKU.getText().equals("") || title.getText().equals("") || price.getText().equals("") || quant.getText().equals("")) {
			errorMsg.setText("Error: An entry is empty");
			return;
		}
		else {
			Integer newSKU = Integer.parseInt(SKU.getText());
			String newTitle = title.getText();
			Double newprice = Double.parseDouble(price.getText());
			Integer newQuant = Integer.parseInt(quant.getText());
			
			book newBook = new book(newSKU, newTitle, newprice, newQuant);
			inventory.add(newBook);
			errorMsg.setText("Book added!");
			return;
		}
	}
	
	public void removeBook() {
		if (inqSKU.getText().equals("")) {
			errorMsg.setText("Please enter SKU No.");
			return;
		}
		else if (inventory.isEmpty()) {
			errorMsg.setText("Inventory is empty");
			return;
		}
		else {
			for (int i = 0; i < inventory.size(); i++) {
				if (inventory.get(i).getSKU() == Integer.parseInt(inqSKU.getText())) {
					inventory.remove(i);
					errorMsg.setText("Book removed!");
				}
				else {
					errorMsg.setText("Book not found!");
				}
			}
			return;
		}
	}
	
	public void findBook() {
		if (inqSKU.getText().equals("")) {
			errorMsg.setText("Please enter SKU No.");
			return;
		}
		else if (inventory.isEmpty()) {
			errorMsg.setText("Inventory is empty");
			return;
		}
		else {
			for (int i = 0; i < inventory.size(); i++) {
				if (inventory.get(i).getSKU() == Integer.parseInt(inqSKU.getText())) {
					System.out.println("Here is the book:");
					System.out.println("");
					System.out.println("SKU No: " + inventory.get(i).getSKU());
					System.out.println("Title: " + inventory.get(i).getTitle());
					System.out.println("Price: $" + inventory.get(i).getPrice());
					System.out.println("Quantity: " + inventory.get(i).getQuantity() + " copies");
					System.out.println("");
				}
				else {
					errorMsg.setText("Book not found!");
				}
			}
			return;
		}
	}
	
	public void printInventory() {
		if (inventory.isEmpty()==true) {
			errorMsg.setText("Inventory is empty!");
		}
		else { 
			for (int i = 0; i < inventory.size(); i++) {
			System.out.println("SKU No: " + inventory.get(i).getSKU());
			System.out.println("Title: " + inventory.get(i).getTitle());
			System.out.println("Price: $" + inventory.get(i).getPrice());
			System.out.println("Quantity: " + inventory.get(i).getQuantity());
			System.out.println("");
			}
		}
		System.out.println("");
	}
	
}
