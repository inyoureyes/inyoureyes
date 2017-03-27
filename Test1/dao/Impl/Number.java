package dao.Impl;

import java.util.Random;

public class Number {
   public static int getNumber(){
	   Random random = new Random();
       //产生随机数
       int ran = (int) Math.random();
       if (ran <= 0.33) {  // 6 位
            ran =100000 + random.nextInt(900000);
       } else if ((ran > 0.33) && (ran < 0.67)) { // 7 位
             ran = 1000000 + random.nextInt(9000000);
       } else { // 8 位
             ran = 10000000 + random.nextInt(90000000);
       }
       int number = (int) ran;
       return number;
	   
	   
   }
  
}

