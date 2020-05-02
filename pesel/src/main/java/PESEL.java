import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PESEL {


    public static boolean isPeselCorrect(String pesel) {
        if (pesel.length() != 11) {
            return false;
        } else {

            int sum = (pesel.charAt(0) - 48) +
                    3 * (pesel.charAt(1) - 48) +
                    7 * (pesel.charAt(2) - 48) +
                    9 * (pesel.charAt(3) - 48) +
                    (pesel.charAt(4) - 48) +
                    3 * (pesel.charAt(5) - 48) +
                    7 * (pesel.charAt(6) - 48) +
                    9 * (pesel.charAt(7) - 48) +
                    (pesel.charAt(8) - 48) +
                    3 * (pesel.charAt(9) - 48);

            sum %= 10;
            sum = 10 - sum;
            sum %= 10;

            return sum == pesel.charAt(10) - 48;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);


        boolean RUN = true;
        HashMap<String, String> zapis = new HashMap<String, String>();

        while(RUN) {

            System.out.println("Chcesz zapisac osobe? Wpisz Tak/Nie");
            String answer = scan.nextLine();


            if(answer.equalsIgnoreCase("nie")) {
                System.out.println("Zakonczenie zapisu osob!");
                RUN = false;
                break;
            } else if (answer.equalsIgnoreCase("tak")) {


                System.out.println("Podaj swoje Miasto, Imie i Nazwisko w jednej linii");
                String firstsecondname = scan.nextLine();

                System.out.println("Podaj swoj PESEL - Dla pomocy powinno sie skladac z 11 cyfr :) ");


                String pesel = scan.nextLine();

                ArrayList<String> dane = new ArrayList<String>();



                String strRet = "";
                if (isPeselCorrect(pesel)) { // tu podpinam swoje sprawdzanie numeru PESEL

                    dane.add(firstsecondname); // jesli jest ok dodaje do listy

                    System.out.println("\n");
                    System.out.println("Zapisane do pliku zostaly ponizsze dane\n");

                    for (String element : dane) {
                        System.out.println(element);
                    }

                    strRet += pesel;
                    System.out.println(strRet);

                    System.out.println("\n");


                    zapis.put(strRet, firstsecondname);

                } else {

                    System.out.println(" Niepowodzenie zapisu! Bledny numer PESEL! Sprobuj ponownie! ");

                }

            }
        }

        File file = new File("tablica_mieszkancow.txt");

        BufferedWriter bf = null;


        try {

            bf = new BufferedWriter(new FileWriter(file));


            for (Map.Entry<String, String> entry : zapis.entrySet()) {

                bf.write(entry.getKey() + " : " + entry.getValue());

                bf.newLine();
            }

            bf.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {

                bf.close();
            } catch (Exception e) {
            }
        }
    }


}




