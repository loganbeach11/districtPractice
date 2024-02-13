import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class Practice {
    public static void main(String[] args) throws Exception {
        P1();//basketball
        P2();//Oomlaw's Principle
        P3();//Palindrome
        P4();//cost of christmas
        P5();
    }
    public static void P1(){
        ArrayList<String> content = FileReader.read("data/P1.dat");
        for(String line : content) {
            switch(line) {
                case "Sammy":   
                    System.out.println("212 is greater than 7");
                    break;
                case "Ashay":
                    System.out.println("so good they call me a robot");
                    break;
            }
        }
    }
    public static void P2(){
        ArrayList<String> content = FileReader.read("data/P2.dat");
        for(int i = 1; i< content.size(); i++){
           String line = content.get(i);
           Scanner scanner = new Scanner(line);
           double a = scanner.nextDouble();
           double b = scanner.nextDouble();
           double c = scanner.nextDouble();
           double d = scanner.nextDouble();
           System.out.printf("%.3f%n",(((a*a)-b)*c)/(212/d));
        }
    }
    public static void P3(){
        ArrayList<String> content = FileReader.read("data/P3.dat");

        MAIN:for(int i = 1; i<content.size(); i++){
            String line = content.get(i);
            for(int j = 0; j<line.length();j++){
                if(line.charAt(j) != line.charAt(line.length()-j-1)){
                    System.out.println("\"NOT A PALINDROME!\"");
                    continue MAIN;
                }
            }
            System.out.println(line);

            for(int j = 1; j<line.length()-1; j++){
                System.out.print(line.charAt(j));
                for(int k = 1; k<line.length()-1; k++){
                 System.out.print(" ");
                }
                System.out.println(line.charAt(j));
            }
            System.out.println(line);
            System.out.println();
        }
    }
    public static void P4() throws Exception{
        Scanner c = new Scanner(new File("data/P4.dat"));
        int count = c.nextInt(); 
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Double> d = new ArrayList<>();
        for(int i = 0; i<count; i++){
            int cost = 0;
            int pres = c.nextInt();
            c.nextLine();
            String name = c.nextLine();
            for(int j = 0; j<pres; j++){
                b.add(c.nextInt());
            }
            for(int j = 0; j<pres; j++){
                d.add(c.nextDouble());
            }
            for(int h = 0; h<pres; h++){
                cost += (b.get(h)*d.get(h));
            }
            if(cost>0){
                System.out.println("It will cost Sammy Klaws $" + cost + " to make " + name + " happy this Christmas!");
            }else{
                System.out.println("It will be free for Sammy Klaws to make " + name + " happy this Christmas!");
            }
            b.clear();
            d.clear();
        }
        c.close();
    }
    public static void P5(){
        
    }
}
