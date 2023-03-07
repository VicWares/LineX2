package org.linechartexample;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;
public class LineChartWithCategoryDatasetExample extends JFrame
{
    public static JFreeChart chart;
    public static DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    public LineChartWithCategoryDatasetExample()//Constructor
    {
        super("LineX2 version 230305");
        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);
        setSize(1800, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new LineChartWithCategoryDatasetExample();
                buildDataSet();
            }
        });
    }
    public static void buildDataSet()
    {
        for (int i = 0; i < 100; i++)
        {
            dataset.addValue(i, "Epoch", (i) + "");
        }
    }
    public static JPanel createChartPanel()
    {
        String chartTitle = "Iris Classifier";
        String categoryAxisLabel = "Epoch";
        String valueAxisLabel = "RMS Error";
        boolean showLegend = false;
        boolean createURL = false;
        boolean createTooltip = false;
        chart = ChartFactory.createLineChart(chartTitle,
                categoryAxisLabel, valueAxisLabel, dataset,
                PlotOrientation.VERTICAL, showLegend, createTooltip, createURL);
        return new ChartPanel(chart);
    }
}