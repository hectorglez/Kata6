package kata6;

import java.awt.Dimension;
import org.jfree.chart.ChartPanel;
import org.jfree.ui.ApplicationFrame;
import org.jfree.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class HistogramDisplay <T> extends ApplicationFrame{

    private final Histogram<T> histo;
    private String nameEjex;

    public HistogramDisplay(Histogram<T> histo, String nameEjeX) {
        super("HISTOGRAM");
        this.histo = histo;
        this.nameEjex = nameEjeX;
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
                nameEjex,
                "Nº Emails",
                dataset,
                PlotOrientation.VERTICAL,
                false,false,false);
            return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (T key : histo.keySet()) {
                dataset.addValue(histo.get(key), "", (Comparable) key);
            }
            return dataset;
    }
    
    public void execute(){
        setVisible(true);
    }

}
