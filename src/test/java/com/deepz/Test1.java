package com.deepz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * created by zhangdingping on 2019/8/26
 */
public class Test1 {
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来
     **/
    public static String measureDistance(List<Double> xList, List<Double> yList, double x, double y) {
          xList.sort(Double::compareTo);
          yList.sort(Double::compareTo);
           if (x >= xList.get(0) && x <= xList.get(xList.size()-1) && y >= yList.get(0) && y <= yList.get(yList.size()-1) ){
               return "yes,0";
           }else{
               //dfs(x+1,y+1);
               return "no,";
           }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        //(x,y)为小广所在的位置
        double x = Double.parseDouble(line.split(",")[0]);
        double y = Double.parseDouble(line.split(",")[1]);

        line = in.nextLine();
        //xList记录了多边形n个点的x坐标,yList记录了多边形n个点的y坐标
        List<Double> xList = new ArrayList<>();
        List<Double> yList = new ArrayList<>();
        String[] array = line.split(",");
        for (int i = 0; i < array.length; i++) {
            xList.add(Double.parseDouble(array[i]));
            yList.add(Double.parseDouble(array[i + 1]));
            i++;
        }
        in.close();
        System.out.println(measureDistance(xList, yList, x, y));
    }

}
