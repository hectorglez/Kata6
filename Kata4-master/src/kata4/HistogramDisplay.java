package kata4;

import java.awt.Dimension;
import org.jfree.chart.ChartPanel;
import org.jfree.ui.ApplicationFrame;
import org.jfree.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
public class HistogramDisplay extends ApplicationFrame{

    private final Histogram<String> histo;

    public HistogramDisplay(Histogram<String> histo) {
        super("HISTOGRAM");
        this.histo = histo;
        setContentPane(createPanel());
        pack();
    }
    
    private ChartPanel createPanel(){
        
        ChartPanel chartPanel = new ChartPanel(creatChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500,450));
        return chartPanel;
    }
    
    private JFreeChart creatChart (DefaultCategoryDataset dataset){
        JFreeChart chart = ChartFactory.createBarChart(
                null,
                "DOMINIOS",
                "Nº Emails",
                dataset,
                PlotOrientation.VERTICAL,
                false,false,false);
            return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (String key : histo.keySet()) {
                dataset.addValue(histo.get(key), "", key);
            }
            return dataset;
    }
    
    public void execute(){
        setVisible(true);
    }

}
