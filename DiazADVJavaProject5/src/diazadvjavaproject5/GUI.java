/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diazadvjavaproject5;

import java.awt.Dimension;
import java.awt.FlowLayout; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Dave
 */
public class GUI extends JFrame {
    // Declare all the different components of the GUI
    private final JRadioButton radBook;
    private final JRadioButton radMovie;
    private final JRadioButton radPainting;
    
    private final JPanel panelA;
    
    private final JLabel lblTitle;
    private final JLabel lblAuthor;
    private final JLabel lblPurchasePrice;
    private final JLabel lblSellingPrice;
    private final JLabel lblDate;
    
    private final JTextField txtTitle;
    private final JTextField txtAuthor;
    private final JTextField txtPurchasePrice;
    private final JTextField txtSellingPrice;
    private final JTextField txtDate;
    
    private final JPanel panelB;
    
    private final JLabel lblActor1;
    private final JLabel lblActor2;
    private final JLabel lblActress1;
    private final JLabel lblActress2;
    private final JLabel lblDirector;
    
    private final JTextField txtActor1;
    private final JTextField txtActor2;
    private final JTextField txtActress1;
    private final JTextField txtActress2;
    private final JTextField txtDirector;
    
    private final JPanel panelC;
    
    private final JLabel lblGenre;
    private final JTextField txtGenre;
    
    private final JPanel panelD;
    
    private final JLabel lblWidth;
    private final JLabel lblHeight;
    private final JLabel lblMedia;
    
    private final JTextField txtWidth;
    private final JTextField txtHeight;
    private final JTextField txtMedia;
    
    private final JPanel panelE;
    
    private final JTextArea txtOutput;
    
    private JLabel lblRecords;
    private JLabel lblProfit;
    
    private final JPanel panelF;
    
    private final JButton btnAdd;
    private final JButton btnSell;
    
    private final JPanel panelG;
    
    private final JButton btnSave;
    private final JButton btnLoad;
    
    private final JPanel panelH;
    
    // Private Date member
    private Date date;
    // The arraylist of StoreItems for the item inventory.
    ArrayList<StoreItem> itemInventory = new ArrayList<StoreItem>();
    
    
    public GUI(){
        super("Inventory");
        setLayout(new FlowLayout());
        

        radBook = new JRadioButton("Book");
        add(radBook);
        
        radMovie = new JRadioButton("Movie");
        add(radMovie);
        
        radPainting = new JRadioButton("Painting" + "\n");
        add(radPainting);
        
        panelA = new JPanel();
        panelA.setBorder(new TitledBorder("Select Catagory:"));
        panelA.add(radBook);
        panelA.add(radMovie);
        panelA.add(radPainting);

        add(panelA);

        lblTitle = new JLabel("Title: ");
        add(lblTitle);
        txtTitle = new JTextField(5);
        add(txtTitle);
        
        lblAuthor = new JLabel("Author: ");
        add(lblAuthor);
        txtAuthor = new JTextField(5);
        add(txtAuthor);
        
        lblPurchasePrice = new JLabel("Purchase Price: ");
        add(lblPurchasePrice);
        txtPurchasePrice = new JTextField(5);
        add(txtPurchasePrice);
        
        lblSellingPrice = new JLabel("Selling Price: ");
        add(lblSellingPrice);
        txtSellingPrice = new JTextField(5);
        add(txtSellingPrice);
        
        lblDate = new JLabel("Date: DD/MM/YY");
        add(lblDate);
        txtDate = new JTextField(5);
        add(txtDate);
        
        panelB = new JPanel();
        panelB.setBorder(new TitledBorder("Fill Out"));
        panelB.add(lblTitle);
        panelB.add(txtTitle);
        panelB.add(lblAuthor);
        panelB.add(txtAuthor);
        panelB.add(lblPurchasePrice);
        panelB.add(txtPurchasePrice);
        panelB.add(lblSellingPrice);
        panelB.add(txtSellingPrice);
        panelB.add(lblDate);
        panelB.add(txtDate);
        
        add(panelB);

        // Movie class section of fields
        lblActor1 = new JLabel("Actor #1: ");
        add(lblActor1);
        txtActor1 = new JTextField(5);
        add(txtActor1);
        
        lblActor2 = new JLabel("Actor #2: ");
        add(lblActor2);
        txtActor2 = new JTextField(5);
        add(txtActor2);
        
        lblActress1 = new JLabel("Actress #1: ");
        add(lblActress1);
        txtActress1 = new JTextField(5);
        add(txtActress1);
        
        lblActress2 = new JLabel("Actress #2: ");
        add(lblActress2);
        txtActress2 = new JTextField(5);
        add(txtActress2);
        
        lblDirector = new JLabel("Director: ");
        add(lblDirector);
        txtDirector = new JTextField(5);
        add(txtDirector);
        
        panelC = new JPanel();
        panelC.setBorder(new TitledBorder("Movie"));
        panelC.add(lblActor1);
        panelC.add(txtActor1);
        panelC.add(lblActor2);
        panelC.add(txtActor2);
        panelC.add(lblActress1);
        panelC.add(txtActress1);
        panelC.add(lblActress2);
        panelC.add(txtActress2);
        panelC.add(lblDirector);
        panelC.add(txtDirector);
        
        add(panelC);

        // Book Section of GUI
        lblGenre = new JLabel("Genre: ");
        add(lblGenre);
        txtGenre = new JTextField(20);
        add(txtGenre);
        
        panelD = new JPanel();
        panelD.setBorder(new TitledBorder("Book"));
        panelD.add(lblGenre);
        panelD.add(txtGenre);
        
        add(panelD);

        // Painting Section of GUI
        lblWidth = new JLabel("Width: ");
        add(lblWidth);
        txtWidth = new JTextField(15);
        add(txtWidth);
        
        lblHeight = new JLabel("Height: ");
        add(lblHeight);
        txtHeight = new JTextField(15);
        add(txtHeight);
        
        lblMedia = new JLabel("Media");
        add(lblMedia);
        txtMedia = new JTextField(15);
        add(txtMedia);
        
        panelE = new JPanel();
        panelE.setBorder(new TitledBorder("Painting"));
        panelE.add(lblWidth);
        panelE.add(txtWidth);
        panelE.add(lblHeight);
        panelE.add(txtHeight);
        panelE.add(lblMedia);
        panelE.add(txtMedia);
        
        add(panelE);
        
        // Output textArea to show each item and the entered data
        txtOutput = new JTextArea(15, 60);
        txtOutput.setEditable(false);
        add(txtOutput);
        
        JScrollPane txtArea = new JScrollPane (txtOutput, 
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        add(txtArea);

        // Record area for profit values
        lblRecords = new JLabel("Records: ");
        add(lblRecords);
        lblProfit = new JLabel("Profit: ");
        add(lblProfit);
        
        panelF = new JPanel();
        panelF.setBorder(new TitledBorder("Data"));
        panelF.add(lblRecords);
        panelF.add(lblProfit);
        
        add(panelF);
        
        // Buttons added to form
        panelG = new JPanel();
        panelG.setBorder(new TitledBorder("Actions"));
        Dimension myDim = new Dimension(350,23);
        btnAdd = new JButton("Add to Inventory");
        btnAdd.setPreferredSize(myDim);
        add(btnAdd);
        btnSell = new JButton("Sell Last Item");
        btnSell.setPreferredSize(myDim);
        add(btnSell);
        
        panelG.add(btnAdd);
        panelG.add(btnSell);
        
        add(panelG);
        
        //Add the Save and Load from file buttons
        panelH = new JPanel();
        panelH.setBorder(new TitledBorder("Save/Load"));
        
        btnSave = new JButton("Save to File");
        btnSave.setPreferredSize(myDim);
        add(btnSave);
        
        btnLoad = new JButton("Load from File");
        btnLoad.setPreferredSize(myDim);
        add(btnLoad);
        
        panelH.add(btnSave);
        panelH.add(btnLoad);
        
        add(panelH);
        
        startState();
        groupButton();
        
        // When the radio button radBook is clicked on, the textfields will
        // be closed except for the Book section
        radBook.addActionListener(new ActionListener() 
        {
        
            @Override
        public void actionPerformed(ActionEvent e) 
        {
                txtWidth.setEnabled(false);
                txtHeight.setEnabled(false);
                txtMedia.setEnabled(false);
                txtActor1.setEnabled(false);
                txtActor2.setEnabled(false);
                txtActress1.setEnabled(false);
                txtActress2.setEnabled(false);
                txtDirector.setEnabled(false);
                
                txtGenre.setEnabled(true);
                
                btnAdd.setEnabled(true);
                
                lblActor1.setEnabled(false);
                lblActor2.setEnabled(false);
                lblActress1.setEnabled(false);
                lblActress2.setEnabled(false);
                lblDirector.setEnabled(false);
                
                lblWidth.setEnabled(false);
                lblHeight.setEnabled(false);
                lblMedia.setEnabled(false);
                panelD.setEnabled(true);
                lblGenre.setEnabled(true);
                panelG.setEnabled(true);

        }
        });
        
        // When the radio button radMovie is clicked on, the textfields will
        // be closed except for the Movie section
        radMovie.addActionListener(new ActionListener() 
        {
            @Override
        public void actionPerformed(ActionEvent e) 
        {
                txtGenre.setEnabled(false);
                txtWidth.setEnabled(false);
                txtHeight.setEnabled(false);
                txtMedia.setEnabled(false);
                
                txtActor1.setEnabled(true);
                txtActor2.setEnabled(true);
                txtActress1.setEnabled(true);
                txtActress2.setEnabled(true);
                txtDirector.setEnabled(true);
                
                btnAdd.setEnabled(true);
                
                lblWidth.setEnabled(false);
                lblHeight.setEnabled(false);
                lblMedia.setEnabled(false);
                
                
                lblActor1.setEnabled(true);
                lblActor2.setEnabled(true);
                lblActress1.setEnabled(true);
                lblActress2.setEnabled(true);
                lblDirector.setEnabled(true);
                
                panelC.setEnabled(true);
                panelD.setEnabled(false);
                lblGenre.setEnabled(false);
                panelG.setEnabled(true);
        }
        });
        
        // When the radio button radPainting is clicked on, the textfields will
        // be closed except for the Painting section
        radPainting.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) {
                txtActor1.setEnabled(false);
                txtActor2.setEnabled(false);
                txtActress1.setEnabled(false);
                txtActress2.setEnabled(false);
                txtGenre.setEnabled(false);
                txtDirector.setEnabled(false);
                
                txtWidth.setEnabled(true);
                txtHeight.setEnabled(true);
                txtMedia.setEnabled(true);
                
                btnAdd.setEnabled(true);
                
                lblActor1.setEnabled(false);
                lblActor2.setEnabled(false);
                lblActress1.setEnabled(false);
                lblActress2.setEnabled(false);
                lblDirector.setEnabled(false);
                
                
                lblWidth.setEnabled(true);
                lblHeight.setEnabled(true);
                lblMedia.setEnabled(true);
                
                panelC.setEnabled(false);
                panelD.setEnabled(false);
                lblGenre.setEnabled(false);
                panelG.setEnabled(true);
                panelE.setEnabled(true);
        }
        });
        
        // When button btnAdd is clicked, it will add the item to the store inventory
        btnAdd.addActionListener(new ActionListener() 
        { 
        public void actionPerformed(ActionEvent e) 
        { 
            btnAddAction();
            
            // Sets the following labels and panels to be enabled
            lblRecords.setEnabled(true);
            lblProfit.setEnabled(true);
            panelF.setEnabled(true);
        } 
        } );

        // When button btnSell is clicked, it will take the item out of the inventory
        // as the sale is completed.
        btnSell.addActionListener(new ActionListener() 
        { 
        public void actionPerformed(ActionEvent e) 
        { 
            // Sell item method
            btnSellAction();
            lblRecords.setEnabled(true);
            lblProfit.setEnabled(true);
            panelF.setEnabled(true);
        } 
        } );
        
        // When button btnSave is clicked, the inventory will be saved to a file
        btnSave.addActionListener(new ActionListener() 
        { 
        public void actionPerformed(ActionEvent e) 
        { 
            // Save to file method
            saveToFile();
            lblRecords.setEnabled(true);
            lblProfit.setEnabled(true);
            panelF.setEnabled(true);
        } 
        } );
        
        // When button btnLoad is clicked, the inventory will be loaded from the file
        // into the textArea
        btnLoad.addActionListener(new ActionListener() 
        { 
        public void actionPerformed(ActionEvent e)
        { 
            // Load from file method
            loadFromFile();
            lblRecords.setEnabled(true);
            lblProfit.setEnabled(true);
            panelF.setEnabled(true);
        } 
        } );
    }
    
    // Simple Method, once the program starts many fields will be disabled
    // until the user chooses a radio button
    private void startState()
    {
        txtWidth.setEnabled(false);
        txtHeight.setEnabled(false);
        txtMedia.setEnabled(false);
        
        txtActor1.setEnabled(false);
        txtActor2.setEnabled(false);
        txtActress1.setEnabled(false);
        txtActress2.setEnabled(false);
        txtDirector.setEnabled(false);
        
        lblActor1.setEnabled(false);
        lblActor2.setEnabled(false);
        lblActress1.setEnabled(false);
        lblActress2.setEnabled(false);
        lblDirector.setEnabled(false);
        
        lblWidth.setEnabled(false);
        lblHeight.setEnabled(false);
        lblMedia.setEnabled(false);
        
        txtGenre.setEnabled(false);
        lblGenre.setEnabled(false);
        
        btnAdd.setEnabled(false);
        btnSell.setEnabled(false);
        
        panelB.setEnabled(true);
        panelC.setEnabled(false);
        panelD.setEnabled(false);
        panelE.setEnabled(false);
        panelF.setEnabled(false);
        panelG.setEnabled(false);
        
        lblRecords.setEnabled(false);
        lblProfit.setEnabled(false);
    }

    // The groupButton method will group the radio buttons together and only one to be selected
    // at a time
    private void groupButton(){
        // Create new ButtonGroup called bg
        ButtonGroup bg = new ButtonGroup();
        // add all the radio buttons to it
        bg.add(radBook);
        bg.add(radMovie);
        bg.add(radPainting);
    }
    
    // This btn
    private void btnAddAction() {                                       
        // Placeholders for purchasePrice and SellingPrice values
        int buy = 0, sell = 0;
        // Placeholders width and height for painting
        int width = 0, height = 0;
        
        // Try-catch block
        try
        {
            // Tests for non-integer inputs
            buy = Integer.parseInt(txtPurchasePrice.getText());
            sell = Integer.parseInt(txtSellingPrice.getText());  
        } catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Invalid input, Please enter Integers!", 
                    "Purchase or Selling Price Error", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Invalid input, Please enter Integers!", 
                    "Purchase or Selling Price Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
        // Try-catch block
        try 
        {
            // Tests date input is in the proper format
            date = new SimpleDateFormat("MM/dd/yy", Locale.ENGLISH).parse(txtDate.getText());
            
        } 
        catch (ParseException ex)
        {
            JOptionPane.showMessageDialog(null, "Invalid input, Enter valid date in this form: MM/DD/YY", 
                    "Date Error", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Invalid input, Enter valid date in this form: MM/DD/YY", 
                    "Date Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
        // If the radio button radBook is selected
        if(radBook.isSelected()){
            // If any of the textboxes in the book section are empty
            if(txtTitle.getText().isEmpty() || txtAuthor.getText().isEmpty() || txtDate.getText().isEmpty() ||
                    txtPurchasePrice.getText().isEmpty() || txtSellingPrice.getText().isEmpty() || txtGenre.getText().isEmpty()){
                // Show error message
                JOptionPane.showMessageDialog(null, "Empty Field(s)!");
                return;
            }
            // Store book into the inventory by passing to constructor
            Book bk = new Book(txtTitle.getText(), txtAuthor.getText(), date, buy, sell, txtGenre.getText());

            // Add new book to the arraylist
            itemInventory.add(bk);
            // Enable Sell button
            btnSell.setEnabled(true);
            
            // Display inventory in the output textArea
            txtOutput.setText("");
            printInventory();
        }
        
        // If the radio button radMovie is selected
        else if(radMovie.isSelected()){
            // If any of the textboxes in the movie section are empty
            if(txtTitle.getText().isEmpty() || txtAuthor.getText().isEmpty() || txtDate.getText().isEmpty() ||
                    txtPurchasePrice.getText().isEmpty() || txtSellingPrice.getText().isEmpty() || txtActor1.getText().isEmpty()
                    || txtActor2.getText().isEmpty() || txtActress1.getText().isEmpty() || txtActress2.getText().isEmpty()
                    || txtDirector.getText().isEmpty()){
                // Show error message
                JOptionPane.showMessageDialog(null, "Empty Field(s)!");
                return;
            }
            // Store movie into the inventory by passing to constructor
            Movie mv = new Movie(txtTitle.getText(), txtAuthor.getText(), date, buy, sell,
                                    txtActor1.getText(), txtActor2.getText(), txtActress1.getText(),
                                    txtActress2.getText(), txtDirector.getText());
            // Add movie to arraylist
            itemInventory.add(mv);
            // enable Sell button
            btnSell.setEnabled(true);
            
            // Display inventory in the output textArea
            txtOutput.setText("");
            printInventory();
        }
        
        // If the radio button radPainting is selected
        else if(radPainting.isSelected())
        {
            
            // Try-catch block
            try
            {
                // Check for invalid non-integer inputs for width and height fields
                width = Integer.parseInt(txtWidth.getText());
                height = Integer.parseInt(txtHeight.getText());  
                // catch parse error
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Invalid input, Please enter Integers!", 
                        "Purchase or Selling Price Error", JOptionPane.INFORMATION_MESSAGE);
            }
            
            // If any of the textboxes in the movie section are empty
            if(txtTitle.getText().isEmpty() || txtAuthor.getText().isEmpty() || txtDate.getText().isEmpty() ||
                    txtPurchasePrice.getText().isEmpty() || txtSellingPrice.getText().isEmpty() | txtMedia.getText().isEmpty() 
                    || txtWidth.getText().isEmpty() ||  txtHeight.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Empty Field(s)!");
                return;
            }
            
            // Store Painting into the inventory by passing to constructor
            Painting pt = new Painting(txtTitle.getText(), txtAuthor.getText(), date, buy, sell,
                                    width, height, txtMedia.getText());
            // Add painting to the arraylist
            itemInventory.add(pt);
            // enable delete button
            btnSell.setEnabled(true);
            
            // Display inventory in the output textArea
            txtOutput.setText("");
            printInventory();
        }
    } 
    
    // Prints the values of the inventory into the text area while denoting what 
    // type of item and the format for printing
    private void printInventory(){
        // Integer placeholders for the profit of each type for book, movie, and painting
        int profitA = 0, profitB = 0, profitC = 0;
        // Integer placeholder counts for book, movie, and painting
        int countA = 0, countB = 0, countC = 0;
        // Integer placeholder for total items
        int totalItems = 0;
        // Integer placeholder for total profit.
        int total;
        
        // Iterate through the arraylist
        for(int i = 0; i < itemInventory.size(); i++){
            // Check if the position is a book
            if(itemInventory.get(i) instanceof Book){
                // Display book string
                txtOutput.append(((Book)itemInventory.get(i)).toString() + "\n");
                // Set profitA to the difference of the book methods
                profitA += itemInventory.get(i).getAskingPrice() - itemInventory.get(i).getPurchasePrice();
                // Set count a to the book count method
                countA = ((Book)itemInventory.get(i)).getBookCount();
            }
            
            // If the position is a movie
            else if(itemInventory.get(i) instanceof Movie){
                // Display movie strong
                txtOutput.append(((Movie)itemInventory.get(i)).toString()+ "\n");
                // Set profit to difference of askingPrice and PurchasePrice member methods
                profitB += itemInventory.get(i).getAskingPrice() - itemInventory.get(i).getPurchasePrice();
                // Set count b to the movieCount member method
                countB = ((Movie)itemInventory.get(i)).getMovieCount();
            }
            // If the position is a painting
            else if(itemInventory.get(i) instanceof Painting){
                // Display painting string
                txtOutput.append(((Painting)itemInventory.get(i)).toString() + "\n");
                // Set profit to difference of askingPrice and PurchasePrice member methods
                profitC += itemInventory.get(i).getAskingPrice() - itemInventory.get(i).getPurchasePrice();
                // Set countC to the member method value PaintingCount
                countC = ((Painting)itemInventory.get(i)).getPaintingCount();
            }
            // Set total items to the StoreItem itemCount
            totalItems = itemInventory.get(i).getCount();
        }
        
        // Set lblRecords to show the count of each item type
        lblRecords.setText("Books: " + countA  + "       Movies: " + countB + "       Paintings: " +
                         countC + "        Total Items: " + totalItems);
        // Calculate total profit with the other profit variables
        total = profitA + profitB + profitC;
        // Set lblProfit to display the total profit
        lblProfit.setText("Potential Profit: $ " + Integer.toString(total));
    }
    
    private void btnSellAction() 
    {                                        
        // Remove last item added in the form of a sale
        itemInventory.remove(itemInventory.size()-1);
        // Checks if its a movie/book/ painting and decrement their count
        try{
            if(itemInventory.get(itemInventory.size()-1) instanceof Book){
                ((Book)itemInventory.get(itemInventory.size()-1)).deleteBook();
            }
            else if(itemInventory.get(itemInventory.size()-1) instanceof Movie){
                ((Movie)itemInventory.get(itemInventory.size()-1)).deleteMovie();
            }
            else {
                ((Painting)itemInventory.get(itemInventory.size()-1)).deletePainting();
            }
            // Catch exception
        }catch (IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Inventory is Now Empty", 
                    "Invalid Index", JOptionPane.INFORMATION_MESSAGE);
            // Set all counts to zero if the arraylist is empty
            StoreItem.itemCount = 0;
            Book.bookCount = 0;
            Movie.movieCount = 0;
            Painting.paintingCount = 0;

            // Disable the delete button
            btnSell.setEnabled(false);
        }
        // Show the inventory in the output textArea
        txtOutput.setText("");
        printInventory();
    }

    // saveToFile method for Serialization
    private void saveToFile()
    {
        // If the output field isn't empty
        if(txtOutput.getText().compareTo("") != 0){
            // Create a string for the fileName
            String fileName;
            // Create a filter for the file chooser for .ser type files
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Serializable", "ser");
            // Create file chooser
            JFileChooser fc = new JFileChooser();
            // Add filter to file chooser
            fc.setFileFilter(filter);
            // Create a new file
            fc.setSelectedFile(new File("Inventory.ser"));
            // Set the directory
            File workingDirectory = new File(System.getProperty("user.dir"));
            fc.setCurrentDirectory(workingDirectory);
            // Int response will hold the user response
            int response = fc.showSaveDialog(fc);
            File f = fc.getSelectedFile();
            
            // If the user option is valid
            if(response == JFileChooser.APPROVE_OPTION)
            {
                try{
                    // See if the file exists
                    if(f.exists())
                    {
                        // Ask the user for permission to overwrite the file
                        int result = JOptionPane.showConfirmDialog(rootPane,"The file exists, overwrite?","Existing file",
                                     JOptionPane.YES_NO_CANCEL_OPTION);
                        // Switch statement using the permission confirmation
                        switch(result){
                            // In the case that the user selected Yes.
                            case JOptionPane.YES_OPTION:
                                // Set the filename to the file the user has selected
                                fileName = fc.getSelectedFile().toString();
                                // Try-catch block
                                try(BufferedWriter output = Files.newBufferedWriter(Paths.get(fileName))){
                                    // Create an output stream so we can serialize the object
                                    FileOutputStream fileOut = new FileOutputStream(fileName);
                                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                                    // Write the object to the file
                                    out.writeObject(itemInventory);
                                    // Close the file streams
                                    out.close();
                                    fileOut.close();
                                    // Display message that the file has been saved
                                    JOptionPane.showMessageDialog(rootPane, "Inventory Saved!");
                                // Catch
                                } catch (Exception ex) 
                                {
                                    JOptionPane.showMessageDialog(rootPane,"Error, Could Not Save, Try Again");
                                }
                                // return
                                return;
                                
                                // Choice 2 action
                            case JOptionPane.NO_OPTION:
                                JOptionPane.showMessageDialog(rootPane, "Inventory Not Saved!");
                                return;
                                // Choice 3 action
                            case JOptionPane.CLOSED_OPTION:
                                JOptionPane.showMessageDialog(rootPane, "Save Stopped.");
                                return;
                                // Choice 4 action
                            case JOptionPane.CANCEL_OPTION:
                                JOptionPane.showMessageDialog(rootPane, "Save Cancelled.");
                                return;      
                        }
                    }
                    // If there is no file
                    else{
                        // tell the user a new one is created
                        JOptionPane.showMessageDialog(rootPane,"New File Created!");
                        fileName = fc.getSelectedFile().toString();
                        
                        try(BufferedWriter output = Files.newBufferedWriter(Paths.get(fileName))){
                            // Create output stream
                            FileOutputStream fileOut = new FileOutputStream(fileName);
                            ObjectOutputStream out = new ObjectOutputStream(fileOut);
                            // write object to file
                            out.writeObject(itemInventory);
                            
                            // close file
                            out.close();
                            fileOut.close();
                            
                            // Tell the user the file is saved
                            JOptionPane.showMessageDialog(rootPane, "Inventory Saved!");
                            clearAll();
                        // Throw Exception  
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(rootPane,"Error, File Did Not Save, Try Again");
                        }
                    }
                 // Throw Exception 
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(rootPane,"Error, File Did Not Save.");
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane,"Error, File Did Not Save, Try Again");
            }
            
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Nothing to save!  Please add Items to the inventory.");
        }
    }
    
    public void loadFromFile(){
        // File extension filter
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".ser", "ser");
        // Create a file chooser
        JFileChooser fin = new JFileChooser();
        // Set the filter
        fin.setFileFilter(filter); 
        // Set the directory
        File workingDirectory = new File(System.getProperty("user.dir"));
        fin.setCurrentDirectory(workingDirectory);
        fin.showOpenDialog(null); 
        File f = fin.getSelectedFile();
        
        try{
            // Try to get the path
            String filename = f.getAbsolutePath();
            // check the file type
            if(checkType(fin)){
                // clear the array list
                itemInventory.clear();
                // create a file reader
                try(FileReader reader = new FileReader(filename); 
                    BufferedReader br = new BufferedReader(reader)){
                    // create input stream
                    FileInputStream fileIn = new FileInputStream(filename);
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    // read the objects into the arraylist of storeitems
                    itemInventory = (ArrayList) in.readObject();
                    // close streams
                    in.close();
                    fileIn.close();
                    // print inventory
                    printInventory();
                // Throw exception
                }catch(ClassNotFoundException c){
                    JOptionPane.showMessageDialog(rootPane,"File Error, Please Try Again.");
                    c.printStackTrace();
                    return;
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(rootPane,"File Error, Please Try Again.");
                    ex.printStackTrace();
                    return;
                }
            }
            // Throw Exception
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane,"No file selected");
            return;
        }
        
    }
    
    // This boolean checkType method will check the type of file that is being chosen from the JFileChooser
    // if it is not a .ser or .text file.
    private boolean checkType(JFileChooser fin){
        String[] splits = fin.getSelectedFile().getName().split("\\.");
        String extension = splits[splits.length-1];  
        return (extension.compareTo("ser") == 0 || extension.compareTo("text") == 0);
    }
    
    // This void method clearAll clears all the textboxes and labels in the GUI
    public void clearAll(){
        txtTitle.setText("");
        txtAuthor.setText("");
        txtPurchasePrice.setText("");
        txtSellingPrice.setText("");
        txtDate.setText("");
        txtActor1.setText("");
        txtActor2.setText("");
        txtActress1.setText("");
        txtActress2.setText("");
        txtDirector.setText("");
        txtGenre.setText("");
        txtWidth.setText("");
        txtHeight.setText("");
        txtMedia.setText("");
    }
}



