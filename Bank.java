package org.example;

//imports
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import org.mindrot.jbcrypt.BCrypt;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
//end of imports

/**
 * Class bank connects front end to database and handles users
 * @author manan
 */

public class Bank {
    HashMap<Integer, String> userPasswords; //stores username and password combos
    HashMap<Integer, Person> people; //stores people

    /**
     * loads in example user and other users in data.txt
     * @throws FileNotFoundException
     * @throws IOException
     */
    public Bank() throws FileNotFoundException, IOException{
        userPasswords = new HashMap<>();
        people = new HashMap<>();


        InputStream users = Bank.class.getClassLoader().getResourceAsStream("users.txt");
        Scanner scanner = new Scanner(users);
        int username = scanner.nextInt();
        userPasswords.put(username, scanner.next());
        String user = scanner.next();
        double b1 = scanner.nextDouble();
        double b2 = scanner.nextDouble();
        LinkedHashMap<LocalDateTime,Double> t1 = new LinkedHashMap<>();
        LinkedHashMap<LocalDateTime,Double> t2 = new LinkedHashMap<>();
        int t1size = scanner.nextInt();
        if(t1size != 0){
            for(int i = 0; i < t1size; i++){

                t1.put(LocalDateTime.parse(scanner.next() + ""),scanner.nextDouble());
            }
        }
        int t2size = scanner.nextInt();
        if(t2size != 0){
            for(int i = 0; i < t2size; i++){

                t2.put(LocalDateTime.parse(scanner.next() + ""),scanner.nextDouble());
            }
        }
        people.put(username, new Person(user,b1,b2,t1,t2));


        scanner = new Scanner(new File("data.txt"));


        while(scanner.hasNextLine()){
            username = scanner.nextInt();
            userPasswords.put(username, scanner.next());
            user = scanner.next();
            b1 = scanner.nextDouble();
            b2 = scanner.nextDouble();
            t1 = new LinkedHashMap<>();
            t2 = new LinkedHashMap<>();
            t1size = scanner.nextInt();
            if(t1size != 0){
                for(int i = 0; i < t1size; i++){

                    t1.put(LocalDateTime.parse(scanner.next() + ""),scanner.nextDouble());
                }
            }
            t2size = scanner.nextInt();
            if(t2size != 0){
                for(int i = 0; i < t2size; i++){

                    t2.put(LocalDateTime.parse(scanner.next() + ""),scanner.nextDouble());
                }
            }
            people.put(username, new Person(user,b1,b2,t1,t2));
        }




    }

    /**
     * creates a new user
     * uses BCrypt to encrypt password and put it in people with the hashcode of username as key
     * returns true if successful
     * returns false if username exists
     * @param user
     * @param pass
     * @return
     * @throws IOException
     */
    public boolean newUser(String user, String pass) throws IOException{
        if(userPasswords.containsKey(user.hashCode())){ //returns false if the username already exists
            return false;
        }

        String hashedPass = BCrypt.hashpw(pass, BCrypt.gensalt());
        userPasswords.put(user.hashCode(), hashedPass); //creates new username and password in hashmap

        people.put(user.hashCode(),new Person(user)); //creates new person



        return true;
    }


    /**
     * logs existing users in
     * returns the id of the person if login successful
     * returns -1 if user/password combination don't match
     * @param user
     * @param pass
     * @return
     */
    public int login(String user, String pass){
        if(userPasswords.containsKey(user.hashCode())){
            String storedPass = userPasswords.get(user.hashCode());
            if (BCrypt.checkpw(pass, storedPass)){
                return user.hashCode();
            }
        }
        return -1;
    }

    /**
     * returns the person with id id
     * @param id
     * @return
     */
    public Person getPerson(int id){
        return people.get(id);
    }

    /**
     * deposits money into a person's appropriate account with Person.deposit
     * @param id
     * @param amount
     * @param account
     */
    public void deposit(int id, double amount, int account){
        people.get(id).deposit(amount,account);
    }

    /**
     * withdraws money from a person's account
     * returns true if successful
     * returns false if insufficient funds
     * @param id
     * @param amount
     * @param account
     * @return
     */
    public boolean withdraw(int id, double amount, int account){
        return people.get(id).withdraw(amount,account);
    }

    /**
     * uses a fileWriter to write all existing data in all structures into users.txt
     * @throws IOException
     */
    public void write() throws IOException{
        File file = new File("data.txt");
        try (FileWriter f = new FileWriter(file)) {
            String output = "";
            for(int x : userPasswords.keySet()){
                output += x + " " + userPasswords.get(x)  + " " + people.get(x) + "\n";
            }

            f.write(output.trim());
        }
    }

    /**
     * uses a PDF writer to write transactions data into a pdf and save it as a pdf
     * then opens the pdf
     * @param id
     * @param account
     * @throws IOException
     */
    public void export(int id, int account) throws IOException{

        DecimalFormat DecFor = new DecimalFormat("#,###.##");
        String fileName;
        String acc = "Checking transactions";

        if(account == 1){
            fileName = "transactions_"+people.get(id).getUser()+"_checking.pdf";
        }
        else{
            fileName = "transactions_"+people.get(id).getUser()+"_savings.pdf";
            acc = "Savings";
        }

        String output = "\n\n";

        for(LocalDateTime x : people.get(id).getTransactions(account).keySet()){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MM/dd/yyyy, hh:mm a");
            output += x.format(formatter) + ": " + DecFor.format(people.get(id).getTransactions(account).get(x)) + "\n";
        }

        if(account == 1){
            output += "Final balance: $" + DecFor.format(people.get(id).getBalance1());        }
        else{
            output += "Final balance: $" + DecFor.format(people.get(id).getBalance2());
        }


        PDDocument document = new PDDocument();

        PDPage page = new PDPage(PDRectangle.LETTER);
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.beginText();

        contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 30);

        contentStream.newLineAtOffset(100, 700);

        contentStream.showText(acc);

        contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);

        contentStream.newLineAtOffset(10, -20);

        String[] lines = output.split("\n");

        for (String line : lines) {
            contentStream.showText(line);
            contentStream.newLineAtOffset(0, -20); // Adjust the offset based on font size
        }

        contentStream.endText();

        contentStream.close();

        document.save(fileName);

        File file = new File(fileName);

        Desktop.getDesktop().open(file);
    }

}
