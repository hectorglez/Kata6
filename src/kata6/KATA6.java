package kata6;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class KATA6 {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        System.out.println("Inicio");
        String nameFile = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\Kata4-master\\DATA\\emailsfilev1.txt";
        ArrayList<Person> mailArray = MailListReader.read(nameFile);
        System.out.println(mailArray.size());
        
        HistogramBuilder<Person> builder = new HistogramBuilder<>(mailArray);
        
        Histogram<String> domains = builder.build(new Attribute<Person, String>() {

            @Override
            public String get(Person item) {
                return item.getMail().split("@")[1];                
            }
        });
        Histogram<Character> letters = builder.build(new Attribute<Person, Character>() {

            @Override
            public Character get(Person item) {
                return item.getMail().charAt(0);                
            }
        });
        new HistogramDisplay(domains,"DOMINIOS").execute();
        new HistogramDisplay(letters,"CARACTER").execute();
        System.out.println("Fin");
        
        System.out.println("Inicio bd");
        
        ArrayList<Person1> person = PersonaLoader.read();
        System.out.println(person.size());
        
        HistogramBuilder<Person1> builder1 = new HistogramBuilder<>(person);
        
        Histogram<String> domains1 = builder1.build(new Attribute<Person1, String>() {

            @Override
            public String get(Person1 item) {
                return item.getMail().split("@")[1];                
            }
        });
        Histogram<Float> pesos = builder1.build(new Attribute<Person1, Float>() {

            @Override
            public Float get(Person1 item) {
                return item.getPeso();                
            }
        });
        Histogram<Character> genero = builder1.build(new Attribute<Person1, Character>() {

            @Override
            public Character get(Person1 item) {
                return item.getGenero().charAt(0);                
            }
        });
        
        new HistogramDisplay(domains1,"DOMINIOS").execute();
        new HistogramDisplay(genero,"CARACTER").execute();
        new HistogramDisplay(pesos,"PESOS").execute();
        System.out.println("Fin bd");
    }
}
