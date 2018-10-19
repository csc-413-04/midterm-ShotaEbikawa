package midterm2018;

import javax.sound.midi.SysexMessage;
import com.google.gson.*;

import java.util.ArrayList;

class Q3 {
    private String task;
    private int num;

    public Q3(String task, int num) {
        this.task = task;
        this.num = num;
    }
    public String getTask() {
        return task;
    }
    public int getNum() {
        return num;
    }

    public int incrementNum() {
        this.num = this.num +1;
        return num;
    }
}

public class Main {

    public static boolean NumCheck(String num) {
        try {
            int num_check = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String question1and2 = "GET /add?a=3&b=4 HTTP/1.1\n"
            + "Host: localhost:1298\n"
            + "Connection: keep-alive\n"
            + "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36\n"
            + "Accept: image/webp,image/apng,image/*,*/*;q=0.8\n"
            + "Referer: http://localhost:1298/\n"
            + "Accept-Encoding: gzip, deflate, br\n"
            + "Accept-Language: en-US,en;q=0.9,es;q=0.8\n";

        String question3 = "{\n"
                + "    “task” : “inc”,\n"
                + "    “num” : 3\n"
                + "}\n";

        String question4and5 = "To opt out, you’ll need to enter the Settings menu by clicking the three vertical dots, all the way in the upper right corner of the browser. From there, you’ll need to enter the Advanced settings at the very bottom and find the “Allow Chrome sign in” toggle, then turn it to off. Doing so lets you sign into Google services like Gmail and Maps without signing into the Chrome browser itself.";


        System.out.println(question1and2);
        System.out.println(question3);
        System.out.println(question4and5);

        // print each answer at the end

        // Question 1
        // Return the Host
        int question1answer = question1and2.indexOf("Host:");
        int connection = question1and2.indexOf("Connection:");
        String host = question1and2.substring(question1answer, connection);
        System.out.println(host);
        // Question 2
        // return sum of a and b
        int get = question1and2.indexOf("GET");
        String get_url = question1and2.substring(get,question1answer);
        int get_a = get_url.indexOf("a=");
        int get_b = get_url.indexOf("b=");
        String a = get_url.substring(get_a+2);
        String b = get_url.substring(get_b+2);
        System.out.println(a);
        int storeA;
        int storeB;
        String store_a = " ";
        String store_b = " ";
        for (int i = 0; i < a.length(); i++) {
            if (NumCheck(a.substring(i,i+1)) == false){
                storeA = a.indexOf(a.substring(i,i+1));
                store_a = a.substring(0,storeA);
                break;
            }
        }

        for (int i = 0; i < b.length(); i++) {
            if (NumCheck(b.substring(i,i+1)) == false){
                storeB = b.indexOf(b.substring(i,i+1));
                store_b = b.substring(0,storeB);
                break;
            }
        }
        int ans2 = Integer.parseInt(store_a) + Integer.parseInt(store_b);
        System.out.println(ans2);
        // Question 3
        // convert to java object, increment num, convert back to json and return
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonObject json = (JsonObject) parser.parse(question3);
        String j =  json.toString();
        j = j.replaceAll("“", "");
        j = j.replaceAll("”", "");
        Q3 q3 = gson.fromJson(j, Q3.class);
        q3.incrementNum();
        String ans_q3 = gson.toJson(q3);
        System.out.println(ans_q3);

        // Question 4
        // return unique words
        ArrayList<String> unique = new ArrayList<String>();
        String [] uniquelist = question4and5.split("[!-~]* ");

        for (int i = 0; i < uniquelist.length; i++) {

                System.out.println(uniquelist[i]);
        }

        // Question 5
        // return 2nd most common word

    }
}
