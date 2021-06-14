/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HinhDuLieu;

import java.util.ArrayList;

/**
 *
 * @author TuanDuc
 */
public class hffdh {

    public static void main(String[] args) {
//        ArrayList<String> arr = new ArrayList<>();
//        arr.add("221462830");
//        arr.add("123456789");
//        arr.add("123456788");
//        arr.add("123456787");
//        arr.add("123456786");
//        for(int i = 101; i < 116; i++){
//            int so = Integer.parseInt(String.valueOf(Math.round(Math.random() * 4)));
//            int nam = Integer.parseInt(String.valueOf(Math.round(Math.random() * 9)));
//            int thang = Integer.parseInt(String.valueOf(Math.round(Math.random() * 11 + 1)));
//            int ngay = Integer.parseInt(String.valueOf(Math.round(Math.random() * 29 + 1)));
//            String str = "insert into HOADON values('HD" + i + "', '201" + "-0" + thang + "-" + ngay + "', '" + arr.get(so) + "', 'NV0" + Math.round(Math.random() * 4 + 1) + "')";
//            System.out.println(str);
//            if(i % 5 == 0){
//                System.out.println("");
//            }
//        }

        ArrayList<String> arr = new ArrayList<>();
        for(int i = 1; i < 21; i++){
            if(i < 10){
                arr.add("V0" + i);
            }else{
                arr.add("V" + i);
            }
        }
        for(int i = 81; i < 91; i++){
            int ghe = Integer.parseInt(String.valueOf(Math.round(Math.random() * 9 + 1)));
            int so = Integer.parseInt(String.valueOf(Math.round(Math.random() * 19)));
            String str = "insert into HOADONCHITIET values('HD" + i + "', '" + arr.get(so) + "'," + ghe + ")";
            System.out.println(str);
            if(i % 5 == 0){
                System.out.println("");
            }
        }
    }
}
