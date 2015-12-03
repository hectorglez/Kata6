package kata6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MailListReader {

    
    public static ArrayList<Person> read(String name) throws FileNotFoundException, IOException{
        
        ArrayList<Person> mailList = new ArrayList<>();
        
        BufferedReader fileReader = new BufferedReader(new FileReader(new File(name)));
        String mail;
        Integer id=0;
        while((mail = fileReader.readLine()) != null){
            if(!mail.contains("@")) continue;
            //mailList.add(mail);
            mailList.add(new Person(id++,mail));
        }
        return mailList;
    }
    
}
