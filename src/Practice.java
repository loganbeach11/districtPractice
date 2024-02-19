import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Practice {
    public static void main(String[] args) throws Exception {
        //P1();  //basketball
       // P2();  //Oomlaw's Principle
        //P3();  //Palindrome
       // P4();  //cost of christmas
       // P5();  //Snowflake
        // P6();  //Pizza
        // P7();  //Lift Issues
        // P8();  // Lies (unfinished)
         P9(); //wrapping
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
    public static void P5() throws Exception{
      Scanner c = new Scanner(new File("data/P5.dat"));  
      int count = c.nextInt();
      for(int i = 0; i<count; i++){
        int size = c.nextInt();
        int pos = c.nextInt();
        int len = c.nextInt();
        String mat = c.next();
        String main = c.next();
        String sub = c.next();
        String[][] res = new String[size][size];
        for(int k = 0; k<size; k++){
            for(int j = 0; j<size; j++){
                res[k][j] = mat;
            }
        }
        for(int p = 0; p<size/2+1; p++){
            res[p][p] = main;
            res[p][size/2] = main;
            res[p][size-p-1] = main;
            res[size/2][p] = main;
            res[size-p-1][p] = main;
            res[size-p-1][size/2] = main;
            res[size-p-1][size-p-1] = main;
            res[size/2][size-p-1] = main;
        }

        int g = size / 2 - pos;
        int f = g;
        int count1 = 2;
        int startx = size/2-pos;
        int starty = size/2;
        int lasty = ((size/2)-pos);
        int lastx = size/2;
        while(g > -1 && f > -1) {
            drawBranch(g,f,len, res,sub,pos, count1 ,startx,starty,size, lastx, lasty);
            len--;
            g -= pos;
            f -= pos;
            count1 +=2;
            startx -= pos;
            lasty-= pos;
        }


        for(String[] row : res){
            for(String s : row){
            System.out.print(s);
            }
            System.out.println();
        }

    }
    c.close();
}
    public static void drawBranch(int x, int y, int len, String[][] res, String ch, int pos, int count, int x1, int y1, int size, int lastx, int lasty){
        for(int i = 0; i<len+1; i++){
            res[x-i][y] = ch;
            res[x][y-i] = ch;
            res[x][y+(count*pos)+i] = ch;
            res[x-i][y+(count*pos)] = ch;
            res[x+(count*pos)][y-i] = ch;
            res[x+(count*pos)+i][y] =ch;
            res[x+(count*pos)][y+(count*pos) +i] =ch;
            res[x+(count*pos)+i][y+(count*pos)] =ch;
        }
        for(int k = 0; k<len+1; k++){
            res[x1-k][y1-k] =ch;
           res[x1-k][y1+k] = ch;
            res[(lastx-k)][lasty-k] = ch;
            res[lastx+k][lasty-k] = ch;
            res[lastx+k][(count*pos)+y+k] = ch;
            res[lastx-k][(count*pos)+y+k] = ch;
            res[x1+(count*pos)+k][y1-k] =ch;
            res[x1+(count*pos)+k][y1+k] =ch;
        }
    }
    public static void P6() throws Exception{
        Scanner c = new Scanner(new File("data/P6.dat"));
        int count = c.nextInt();
        c.nextLine();
        boolean flag;
        BIG:for(int i = 0; i<count; i++){
            flag = true;
            String cur = c.nextLine();
            int check = 0;
            String grinch = "";
            for(int h = 0; h<cur.length(); h++){
                if(Character.isDigit(cur.charAt(h))){
                    grinch += cur.substring(h, h+1);
                }
            }
            if(grinch.length() != 10){
                flag = false;
            }
            while(!Character.isDigit(cur.charAt(check))){
                check++;
            }
            if(check == 0){
                System.out.println("TEST " + (i+1) + ": INVALID NUMBER");
                continue BIG;
            }
            if(!cur.substring(check-1, check).equals("(") || !cur.substring(check+3, check+4).equals(")")){
                flag = false;
            }
            if(!Character.isDigit(cur.charAt(check+1)) || !Character.isDigit(cur.charAt(check+2))){
                flag  = false;
            }
            while(!Character.isDigit(cur.charAt(check))){
                check++;
            }          
            if(!Character.isDigit(cur.charAt(check+1)) || !Character.isDigit(cur.charAt(check+2))){
                flag  = false;
            }
            while(!Character.isDigit(cur.charAt(check))){
                check++;
            }              
            if(cur.substring(check, check+1).equals("1") || cur.substring(check, check+1).equals("0")){
                flag = false;
            }
            if(!Character.isDigit(cur.charAt(check)) || !Character.isDigit(cur.charAt(check+1)) || !Character.isDigit(cur.charAt(check+2))){
                flag  = false;
            }
            if(flag && !grinch.equals("8324567890")){
                System.out.println("TEST " + (i+1) + ": ORDER AWAY");
            }else{
            System.out.println("TEST " + (i+1) + ": INVALID NUMBER");
            }
        }
    }
    public static void P7() throws Exception{
        Scanner c = new Scanner(new File("data/P7.dat"));
        int count = c.nextInt();
        for(int i = 0; i<count; i++){
            int cur = c.nextInt();
            if(cur<=21200){
                System.out.println("Sammy Klaws can continue to bring joy to the world!");
            }else{
                System.out.println("Steb tried his best, but Sammy Klaws was just too heavy...no more joy to the world.");
            }
        }
    }
    public static void P8() throws Exception{
        Scanner c = new Scanner(new File("data/P8.dat"));
        //int count = c.nextInt();
        c.nextLine();
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0; i<1; i++){ //count
            ArrayList<String[]> cur = new ArrayList<>();
            for(int j = 0; j<3; j++){
                String cu = c.nextLine();
               String[] current = cu.split(" ");
               cur.add(current);

            }
            for(int f = 0;f<cur.size(); f++){
                String[] cur1 = cur.get(f);
                
            }
            System.out.println(Arrays.toString(cur.get(0)));
            System.out.println(Arrays.toString(cur.get(1)));
            System.out.println(Arrays.toString(cur.get(2)));
        }
    }
    public static void P9() throws Exception{
        Scanner c = new Scanner(new File("data/P9.dat"));
        Scanner s = new Scanner(new File("data/P9.dat"));
        int count = c.nextInt();
        ArrayList<String> boxes = new ArrayList<String>(Arrays.asList("No Box","Cardboard Box", "Fancy Cardboard Box", "Autographed Box"));
        ArrayList<Double> boxes1 = new ArrayList<Double>(Arrays.asList(0.00, 1.08, 2.15, 15.00));
        ArrayList<String> papers = new ArrayList<String>(Arrays.asList("No Wrapping Paper", "Grocery Bag",  "Budget Wrapping Paper", "Fancy Wrapping Paper", "North Pole Wrapping Paper"));
       ArrayList<Double> paper1 = new ArrayList<Double>(Arrays.asList(0.00,0.33, 0.87, 1.73, 3.46));
       s.nextLine();
        for(int i = 0; i<count; i++){
            String line = s.nextLine();
            int space = line.indexOf(" ");
            char check = line.charAt(space+1);
            String name = c.next();
            if(!Character.isDigit(check)){
                name+= " " + c.next();
            }
            ArrayList<String> output1 = new ArrayList<String>(Arrays.asList(" "));   
            String output = "";      
            int cost = c.nextInt();
            int budget = c.nextInt()-cost;
            double length = (c.nextInt() + 0.00)/12.00;
            double width = (c.nextInt() + 0.00)/12.00;
            double height = (c.nextInt() + 0.00)/12.00;
            double area = ((2*length*width) + (2*length*height) + (2*height*width));
            double volume = (length*width*height);
            if(budget<0){
                output += "Can't  Afford " + name + " :(";
            }else{
                output += name + ": ";
                output1.add(name + ": ");
                if( budget < ( volume * boxes1.get(1) )){
                    output +=  "No Box and No Wrapping Paper";
                }else{
                    
                }
            }
            for(int j = 1; j<output1.size(); j++){
                System.out.print(output1.get(i));
                System.out.println();
            }
            output1.clear();
          System.out.println(output);
        }
        c.close();
        s.close();
    }
}
