import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args){

        String[] Rome = {"I","II","III","IV","V","VI","VII","VIII","IX","X","XX","XXX","XL","L","LX","LXX","LXXX","XC","C"};
        String[] Arab = {"1","2","3","4","5","6","7","8","9","10"};
        String[] Dev  = {"+","-","*","/"};

        System.out.println("введите выражение");
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        // запись выражения

        String[] arreyS = str.split(" ");
        int a = 0;
        int b = 0;
        int x = 0;
        boolean itsRome = false;
        boolean itsArab = false;
        boolean itsDew  = false;
        int problema = 2;
        try {
//_______________________________________________________________________________________________
            for (int i = 0; i < 10; i++) {
                if (arreyS[0].equals(Rome[i])) {
                    itsRome = true;
                    a = 1 + i;
                    problema = problema - 1;
                }
                if (arreyS[2].equals(Rome[i])) {
                    itsRome = true;
                    b = 1 + i;
                    problema = problema - 1;
                }
            }
//_______________________________________________________________________________________________
            for (int i = 0; i < Arab.length; i++) {
                if (arreyS[0].equals(Arab[i])) {
                    itsArab = true;
                    a = 1 + i;
                    problema = problema - 1;
                }
                if (arreyS[2].equals(Arab[i])) {
                    itsArab = true;
                    b = 1 + i;
                    problema = problema - 1;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("строка не является математической операцией");
            problema = 10;
        }

//_______________________________________________________________________________________________
        for(int i = 0; i<Dev.length; i++) {
            if (arreyS[1].equals(Dev[i])) {
                int o = i;
                switch (o){
                    case 0 :
                        x = a + b;
                        itsDew = true;
                        break;
                    case 1 :
                        x = a - b;
                        itsDew = true;
                        break;
                    case 2 :
                        x = a * b;
                        itsDew = true;
                        break;
                    case 3 :
                        x = a / b;
                        itsDew = true;
                        break;
                }

            }
        }


        if (problema==1||problema==2){
            try {
                throw new IOException();
            }catch (IOException e){
                System.out.println("Введите число от 0 до 10");

            }
        }
        if (x < 1 && itsRome){
            try {
                throw new IOException();
            }catch (IOException e){
                System.out.println("в римской системе нет отрицательных чисел");

            }
        }
        if (itsRome && itsArab){
            try {
                throw new IOException();
            }catch (IOException e){
                System.out.println("используются одновременно разные системы счисления");
                problema = 10;
            }
        }
        if (arreyS.length<3){
            try {
                throw new IOException();
            }catch (IOException e){
                System.out.println("строка не является математической операцией");
            }
        }

        if (arreyS.length>3||itsDew == false||itsArab == false||itsRome == false){
            try {
                throw new IOException();
            }catch (IOException e){
                System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                problema = 10;
            }
        }



        if (problema==0||problema>10) {


            int e = x / 10;
            int e1 = x % 10;

            if (itsRome) {
                if (x > 10) {
                    if (e1 == 0) {
                        System.out.println(Rome[8 + e]);
                    } else {
                        System.out.println(Rome[8 + e] + Rome[e1 - 1]);
                    }
                }
                System.out.println(Rome[x - 1]);
            } else {
                System.out.println(x);
            }
        }
    }

}