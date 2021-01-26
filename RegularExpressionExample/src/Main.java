import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        //Del 1:
        System.out.println("----- search #1 start -----");
        String pattern = "abcdefghijlklmnopqstuvxyz";
        finderFew(pattern);
        System.out.println("----- search #1 stop -----");
        System.out.println();

        //Del 2:
        System.out.println("----- search #2 start -----");
        pattern = "ola";
        finderCaseInsens(pattern);
        System.out.println("----- search #2 stop -----");
        System.out.println();

        //Del 3:
        System.out.println("----- search #3 start -----");
        pattern = "a{3,5}";
        finderFew(pattern);
        System.out.println("----- search #3 stop -----");
        System.out.println();

        //Del 4:
        System.out.println("----- search #4 start -----");
        pattern = "[^A-Za-z0-9]{2,}";
        finderMany(pattern);
        System.out.println("----- search #4 stop -----");
        System.out.println();

        //Del 5:
        //Här får vi med tecken som förmodligen inte hör hemma i adresserna men jag följer uppgiften.
        System.out.println("----- search #5 start -----");
        pattern = "[A-Za-z0-9._%-]+@[A-Za-z0-9._-]+\\.[A-Za-z]{2,3}";
        finderFew(pattern);
        System.out.println("----- search #5 stop -----");
        System.out.println();

        //Del 6:
        System.out.println("----- search #6 start -----");
        pattern = "[0-9]{3,4}[\\s|\\-|\\/][0-9]{6}";
        finderFew(pattern);
        System.out.println("----- search #6 stop -----");
        System.out.println();

        //Del 7:
        System.out.println("----- search #7 start -----");
        pattern = "([a-zA-Z])\\1\\1\\1";
        finderCaseInsens(pattern);
        System.out.println("----- search #7 stop -----");
        System.out.println();

        //Del 8:
        System.out.println("----- search #8 start -----");
        pattern = "[abcdefghijklmnoprstuxyz]{3}[\\_|\\/][0-9]{3}";
        finderCaseInsens(pattern);
        System.out.println("----- search #8 stop -----");
        System.out.println();

        //Del 9:
        System.out.println("----- search #9 start -----");
        pattern = "\\([A-Za-z1-9\\s\\s]{2,}\\)";
        finderCaseInsens(pattern);
        System.out.println("----- search #9 stop -----");
        System.out.println();

        //Del 10:
        System.out.println("----- search #10 start -----");
        pattern = "(for\\((.){2,}\\))|(if\\((.){2,}\\))";
        finderFew(pattern);
        System.out.println("----- search #10 stop -----");
        System.out.println();

    }
    public static void  finderFew ( String pattern){
        try {
            Pattern p =Pattern.compile(pattern);
            String data;
            File myObj = new File( "src/text.txt");
            Scanner myReader = new Scanner(myObj);
            int counter = 0;
            int finds = 0;
            while (myReader.hasNextLine()) {
                counter++;
                data = myReader.nextLine();
                Matcher matcher = p.matcher(data);

                while(matcher.find()){

                    if(matcher.group().length() != 0) {
                        System.out.println("Match #"+(finds+1) +": "+matcher.group());
                    }
                    finds++;
                    System.out.print("Line: "+ counter+" ");
                    System.out.print ("Start: "+matcher.start()+" " );
                    System.out.println("end: "+matcher.end() );
                    System.out.println(" ".repeat(matcher.start())+"¥ <- (start character)" );
                    System.out.println(data);
                }

            }
            System.out.println("*** FOUND " + finds + " MATCHES IN TOTAL. ***");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public static void finderCaseInsens(String pattern){
        try {
            Pattern p =Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
            String data;
            File myObj = new File( "src/text.txt");
            Scanner myReader = new Scanner(myObj);
            int counter = 0;
            int finds = 0;
            while (myReader.hasNextLine()) {
                counter++;
                data = myReader.nextLine();
                Matcher matcher = p.matcher(data);

                while(matcher.find()){

                    if(matcher.group().length() != 0) {
                        System.out.println("Match #"+(finds+1) +": "+matcher.group());
                    }
                    finds++;
                    System.out.print("Line: "+ counter+" ");
                    System.out.print ("Start: "+matcher.start()+" " );
                    System.out.println("end: "+matcher.end() );
                    System.out.println(" ".repeat(matcher.start())+"¥ <- (start character)" );
                    System.out.println(data);
                }

            }
            System.out.println("*** FOUND " + finds + " MATCHES IN TOTAL. ***");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public static void  finderMany ( String pattern){
        try {
            Pattern p =Pattern.compile(pattern);
            String data;
            File myObj = new File( "src/text.txt");
            Scanner myReader = new Scanner(myObj);
            int counter = 0;
            int finds = 0;
            while (myReader.hasNextLine()) {
                counter++;
                data = myReader.nextLine();
                Matcher matcher = p.matcher(data);
                while(matcher.find()){
                    finds++;
                }
            }
            System.out.println("Found " + finds + " matches in total.");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
