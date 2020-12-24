package com.example.myapp.util;

import com.example.myapp.bean.ControlLine;

import java.util.ArrayList;
import java.util.List;

public class GetService {
    private String[] dayString=new String[]{"6.1","6.2","6.3","6.4","6.5"};
    private String[] expenseString=new String[]{"-135","-65","-408","-136","-38"};
    private String[] incomeString=new String[]{"0","0","0","1500","100"};
    private int[] sumString=new int[]{-135,-65,-408,+1364,+62};


    public List<ControlLine> setControlLineList(){
        List<ControlLine> list=new ArrayList<ControlLine>();
        for (int i=0;i<5;i++){
            ControlLine controlLine=new ControlLine();
            controlLine.setControlDay(dayString[i]);
            controlLine.setCategoryName(expenseString[i]);
            controlLine.setBatchName(incomeString[i]);
            controlLine.setControlLine(sumString[i]);

            list.add(controlLine);
        }
        return  list;
    }
}
