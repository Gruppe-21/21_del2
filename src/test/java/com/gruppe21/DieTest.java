package com.gruppe21;

import org.junit.Test;

public class DieTest {

@Test
    public void normalDistributionTest() {
        Die die1 = new Die();
        Die die2 = new Die();

            int i = 1;
            double two = 0;
            double three = 0;
            double four = 0;
            double five = 0;
            double six = 0;
            double seven = 0;
            double eight = 0;
            double nine = 0;
            double ten = 0;
            double eleven = 0;
            double twelve = 0;
            while (i <= 1000000) { //Throws the die 1000000 times
                die1.rollDie();
                die2.rollDie();

                switch (die1.getValue()+die2.getValue()) {
                    case 2:
                        two++;
                        break;
                    case 3:
                        three++;
                        break;
                    case 4:
                        four++;
                        break;
                    case 5:
                        five++;
                        break;
                    case 6:
                        six++;
                        break;
                    case 7:
                        seven++;
                        break;
                    case 8:
                        eight++;
                        break;
                    case 9:
                        nine++;
                        break;
                    case 10:
                        ten++;
                        break;
                    case 11:
                        eleven++;
                        break;
                    case 12:
                        twelve++;
                        break;
                    default:
                        System.out.println("Error");
                        break;

                }
                i++;
            }

            System.out.println("antallet af 2'ere er: " + two);
            System.out.println("antallet af 3'ere er: " + three);
            System.out.println("antallet af 4'ere er: " + four);
            System.out.println("antallet af 5'ere er: " + five);
            System.out.println("antallet af 6'ere er: " + six);
            System.out.println("antallet af 7'ere er: " + seven);
            System.out.println("antallet af 8'ere er: " + eight);
            System.out.println("antallet af 9'ere er: " + nine);
            System.out.println("antallet af 10'ere er: " + ten);
            System.out.println("antallet af 11'ere er: " + eleven);
            System.out.println("antallet af 12'ere er: " + twelve);

        }
}