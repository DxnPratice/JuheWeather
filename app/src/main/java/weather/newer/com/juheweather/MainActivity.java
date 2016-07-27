package weather.newer.com.juheweather;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ValueFormatter;

import java.util.ArrayList;

import static com.github.mikephil.charting.components.XAxis.*;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dates;//日期
    ArrayList<Integer> temps;//最高温度
    ArrayList<Integer> temps1;//最低温度
    LineChart xLineChart;
    LineChart nLineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xLineChart= (LineChart) findViewById(R.id.max_chart);
        nLineChart= (LineChart) findViewById(R.id.min_chart);
           dates=new ArrayList<>();
            temps=new ArrayList<>();
            temps1=new ArrayList<>();
            dates.add("周日");
            dates.add("周一");
            dates.add("周二");
            dates.add("周三");
            dates.add("周四");
            dates.add("周五");


            temps.add(25);
            temps.add(28);
            temps.add(26);
            temps.add(27);
            temps.add(28);
            temps.add(25);
            temps1.add(15);

            temps1.add(20);
            temps1.add(18);
            temps1.add(15);
            temps1.add(19);
            temps1.add(12);
        LineData    xLineData = getLineData(dates, temps);
        LineData    nLineData = getLineData(dates, temps1);
        showMaxChart(xLineChart, xLineData, Color.rgb(255, 255, 255));
        showMinChart(nLineChart, nLineData, Color.rgb(255, 255, 255));
    }
    // 设置最高温度显示的样式
    private void showMaxChart(LineChart lineChart, LineData lineData, int color) {
        lineChart.setDrawBorders(false);  //是否在折线图上添加边框
        lineChart.setDescription("最高天气温度");// 数据描述
        // 如果没有数据的时候，会显示这个，类似listview的emtpyviewtrue
        lineChart.setNoDataTextDescription("You need to provide data for the chart.");
        lineChart.setDrawGridBackground(true); // 是否显示表格颜色
        lineChart.setGridBackgroundColor(Color.green(160)); // 表格的的颜色，在这里是是给颜色设置一个透明度
        lineChart.setTouchEnabled(true); // 设置是否可以触摸
        lineChart.setDragEnabled(true);// 是否可以拖拽
        lineChart.setScaleEnabled(true);// 是否可以缩放
        //if disabled, scaling can be done on x- and y-axis separately
        lineChart.setPinchZoom(false);//
        lineChart.setBackgroundColor(color);// 设置背景
        lineChart.setData(lineData); // 设置数据

        lineChart.getXAxis().setEnabled(true);//是否显示X坐标轴 及 对应的刻度竖线，默认是true
        lineChart.getXAxis().setDrawAxisLine(true);
        lineChart.getXAxis().setDrawGridLines(true);//是否显示X坐标轴上的刻度竖线，默认是true
        lineChart.getXAxis().setDrawLabels(true); //是否显示X坐标轴上的刻度，默认是true

        lineChart.getXAxis().setTextColor(Color.rgb(0, 0, 0)); //X轴上的刻度文本的颜色
        lineChart.getXAxis().setTextSize(6); //X轴上的刻度的字的大小 单位dp

        lineChart.getXAxis().setGridColor(Color.rgb(0, 3, 64)); //X轴上的刻度竖线的颜色
        lineChart.getXAxis().setGridLineWidth(1); //X轴上的刻度竖线的宽 float类型
        lineChart.getXAxis().enableGridDashedLine(40, 3, 0); //虚线表示X轴上的刻度竖线(float lineLength, float spaceLength, float phase)三个参数，1.线长，2.虚线间距，3.虚线开始坐标
        lineChart.getAxisLeft().setAxisMaxValue(40);// Y坐标轴最大值
        lineChart.getAxisLeft().setAxisMinValue(-5);// Y坐标轴最小值
        lineChart.getAxisLeft().setEnabled(true);//隐藏左边的坐标轴
        lineChart.getAxisRight().setEnabled(true); // 隐藏右边的坐标轴

        //隐藏左边坐标轴横网格线
        lineChart.getAxisLeft().setDrawGridLines(true);
        //隐藏右边坐标轴横网格线
        lineChart.getAxisRight().setDrawGridLines(true);
        //隐藏X轴竖网格线
        lineChart.getXAxis().setDrawGridLines(true);
        lineChart.getXAxis().setPosition(XAxisPosition.BOTTOM); // 让x轴在下面\
        // 设置在Y轴上是否是从0开始显示
        lineChart.setBorderColor(R.color.colorAccent);
        //是否在Y轴显示数据，就是曲线上的数据
        // get the legend (only possible after setting data)
        Legend mLegend = lineChart.getLegend(); // 设置比例图标示，就是那个一组y的value的
        // modify the legend ...
        // mLegend.setPosition(LegendPosition.LEFT_OF_CHART);
        //lineChart.getXAxis().setGridColor(getResources().getColor(R.color.transparent));
        mLegend.setForm(Legend.LegendForm.SQUARE);// 样式
        mLegend.setFormSize(7.0f);// 字体
        mLegend.setTextColor(Color.rgb(255,0,0));// 颜色
        //mLegend.setTypeface(mTf);// 字体
        lineChart.animateX(5000); // 立即执行的动画,x轴
    }
    // 设置最高温度显示的样式
    private void showMinChart(LineChart lineChart, LineData lineData, int color) {
        lineChart.setDrawBorders(false);  //是否在折线图上添加边框
        lineChart.setDescription("最高温度");// 数据描述
        // 如果没有数据的时候，会显示这个，类似listview的emtpyview
        lineChart.setNoDataTextDescription("You need to provide data for the chart.");
        lineChart.setDrawGridBackground(false); // 是否显示表格颜色
        lineChart.setGridBackgroundColor(Color.WHITE & 0x70FFFFFF); // 表格的的颜色，在这里是是给颜色设置一个透明度
        lineChart.setTouchEnabled(true); // 设置是否可以触摸
        lineChart.setDragEnabled(true);// 是否可以拖拽
        lineChart.setScaleEnabled(true);// 是否可以缩放
        // if disabled, scaling can be done on x- and y-axis separately
        lineChart.setPinchZoom(false);//
        lineChart.setBackgroundColor(color);// 设置背景

        // add data
        lineChart.setData(lineData); // 设置数据
        lineChart.getXAxis().setEnabled(true);     //是否显示X坐标轴 及 对应的刻度竖线及文本刻度，默认是true
        lineChart.getXAxis().setDrawAxisLine(true); //是否绘制坐标轴的线，即含有坐标的那条线，默认是true
        lineChart.getXAxis().setDrawGridLines(true); //是否绘制显示X坐标轴上的刻度竖线，默认是true
       lineChart.getXAxis().setDrawLabels(true); //是否绘制显示X坐标轴上的刻度，默认是true*/

        lineChart.getXAxis().setTextColor(Color.rgb(255, 0, 0)); //X轴上的文本刻度的颜色
        lineChart.getXAxis().setTextSize(3); //X轴上的刻度的字的大小 单位dp
//      xAxis.setTypeface(Typeface tf); //X轴上的刻度的字体
        lineChart.getXAxis().setGridColor(Color.rgb(255,0,0)); //X轴上的刻度竖线的颜色
        lineChart.getXAxis().setGridLineWidth(3.0f); //X轴上的刻度竖线的宽 float类型
        //lineChart.getXAxis().enableGridDashedLine(40, 6, 0); //虚线表示X轴上的刻度竖线(float lineLength, float spaceLength, float phase)三个参数，1.线长，2.虚线间距，3.虚线开始坐标
        lineChart.getAxisLeft().setAxisMaxValue(30);// Y坐标轴最大值
        lineChart.getAxisLeft().setAxisMinValue(-20);// Y坐标轴最小值
        lineChart.getAxisLeft().setEnabled(true);//隐藏左边的坐标轴
        lineChart.getAxisRight().setEnabled(true); // 隐藏右边的坐标轴

        //隐藏左边坐标轴横网格线
        lineChart.getAxisLeft().setDrawGridLines(true);
        //隐藏右边坐标轴横网格线
        lineChart.getAxisRight().setDrawGridLines(true);
        //隐藏X轴竖网格线
        lineChart.getXAxis().setDrawGridLines(true);
        lineChart.getXAxis().setPosition(XAxisPosition.BOTTOM); // 让x轴在下面\
        // 设置在Y轴上是否是从0开始显示
        lineChart.setBorderColor(R.color.colorPrimary);
        lineChart.animateX(2500); // 立即执行的动画,x轴
    }
    /**
     * 生成一个数据
     * @param dates 表示图表中的日期
     * @param temps 表示图表中温度
     * @return
     */
    private LineData getLineData(ArrayList<String> dates,ArrayList<Integer> temps) {
        // x轴的数据
        ArrayList<String> xValues = new ArrayList<>();
        // y轴的数据
        ArrayList<Entry> yValues= new ArrayList<>();
        for (int    i = 0; i< dates.size(); i++) {
            // x轴显示的数据，这里默认使用数字下标显示
            xValues.add(dates.get(i));
        }
        for (int  i = 0; i< dates.size(); i++) {
            float y=(float)temps.get(i);
            yValues.add(new Entry(temps.get(i),i));
        }

        // create a dataset and give it a type
        // y轴的数据集合
        LineDataSet lineDataSet = new LineDataSet(yValues, "" /*显示在比例图上*/);
        lineDataSet.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float v) {
                int n=(int)v;
                String str=String.valueOf(n);
                return str+"℃";
            }
        });
        // mLineDataSet.setFillAlpha(110);
        // mLineDataSet.setFillColor(Color.RED);

        //用y轴的集合来设置参数
        lineDataSet.setLineWidth(5); // 线宽
        lineDataSet.setCircleSize(6f);// 显示的圆形大小
        lineDataSet.setColor(Color.GREEN);// 设置折线的显示颜色
        lineDataSet.setCircleColor(Color.rgb(0,0,255));// 圆形的颜色
        lineDataSet.setHighLightColor(Color.WHITE); // 高亮的线的颜色

        ArrayList<LineDataSet>lineDataSets = new ArrayList<LineDataSet>();
        lineDataSets.add(lineDataSet); // add the datasets

        // create a data object with the datasets
        LineData    lineData = new LineData(xValues, lineDataSets);

        return  lineData;
    }
}


