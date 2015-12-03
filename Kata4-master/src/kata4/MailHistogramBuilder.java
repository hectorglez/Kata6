package kata4;

import java.util.ArrayList;

public class MailHistogramBuilder {

    public static Histogram<String> build (ArrayList<String> mailList){
        
        Histogram<String> histogram = new Histogram<>();
        
        for (String mail : mailList) {
            Mail dom = new Mail(mail);
            histogram.increment(dom.getDominio());
        }
        return histogram;
    }
    
}
