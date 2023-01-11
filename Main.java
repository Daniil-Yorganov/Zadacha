
import java.util.Scanner;

public class Main {
    public static void main (String[] args){

        Main ma = new Main();

        System.out.println("введите выражение");
        Scanner s = new Scanner(System.in);
        String strInp = s.nextLine();

        String strOut = ma.calc(strInp);

        System.out.println(strOut);

    }
    public String calc (String strIn) {

            String[] Rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
            String[] Arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            String[] Dev = {"+", "-", "*", "/"};
            String[] arr = strIn.split(" ");
            String out = new String();

            int a = 0;
            int b = 0;
            int x = 0;
            int e = arr.length;

            boolean itRome = false;
            boolean itArab = false;
            boolean itNum = false;
            boolean itDew = false;
            boolean itOk = true;

            try {

                for (int i = 0; i < 10; i++) {
                    if (arr[0].equals(Arab[i])) {
                        a = 1 + i; itArab = true; itNum  = true;}
                    if (arr[2].equals(Arab[i])) {
                        b = 1 + i; itArab = true; itNum  = true;}
                    if (arr[0].equals(Rome[i])) {
                        a = 1 + i; itRome = true; itNum  = true;}
                    if (arr[2].equals(Rome[i])) {
                        b = 1 + i; itRome = true; itNum  = true;}
                }//сканнирует числа

                for (int i = 0; i < 4; i++) {
                    if (arr[1].equals(Dev[i])) {
                        int o = i;
                        itDew = true;
                        switch (o) {
                            case 0: x = a + b; break;
                            case 1: x = a - b; break;
                            case 2: x = a * b; break;
                            case 3: x = a / b; break;
                        }
                    }
                }//сканнирует знак


                if (arr.length>3 || !itDew) {
                    System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    itOk = false;
                }
                if (!itNum) {
                    System.out.println("Введите число от 0 до 10");
                    itOk = false;
                }
                if (itRome && itArab) {
                    System.out.println("используются одновременно разные системы счисления");
                    itOk = false;
                }


                try {

                    if (itRome && itOk) { //выводит строку так как надо
                        if (x > 10) {
                            int b10 = x / 10;
                            int b01 = x % 10;
                            if (b01 == 0) {
                                out = Rome[b10 + 8];
                            } else {out = Rome[b10 + 8] + Rome[b01 - 1];}
                        } else {out = Rome[x - 1];}
                    } else if (itOk) {out = Integer.toString(x);}


                } catch (ArrayIndexOutOfBoundsException e1) {
                    System.out.println("в римской системе нет отрицательных чисел");
                }

            } catch(ArrayIndexOutOfBoundsException e1) {
                System.out.println("строка не является математической операцией");
            }


            return out;
        }


}