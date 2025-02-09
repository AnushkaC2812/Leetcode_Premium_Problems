import java.util.Arrays;
import java.util.Scanner;

public class OneEditDistance {

    private static boolean helper(String s, String t){

        if(Math.abs(s.length()-t.length()) > 1)
            return false;

        if(s.equals(t))
            return false;

        char sArray[] = s.toCharArray();
        char tArray[] = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        s = new String(sArray);
        t = new String(tArray);

        int i = 0, j = 0;
        int count = 0;

        while(i<s.length() && j<t.length()){
            if(s.charAt(i) != t.charAt(j)){
                //in case replacement is needed
                if(s.length() == t.length()){
                    count++;
                    i++; j++;
                }

                //in case insertion or deletion is needed
                else{
                    //if insertion is needed
                    if(j+1<t.length()){
                        if(s.charAt(i) == t.charAt(j+1)) {
                            count++;
                            j++;
                        } else return false;
                    }

                    //if deletion is needed
                    else if(i+1<s.length()){
                        if(s.charAt(i+1) == t.charAt(j)) {
                            count++;
                            i++;
                        } else return false;
                    }
                }
                if(count > 1) return false;
            }
            else {
                i++; j++;
            }
        }

        if(i<s.length()-1 || j<t.length()-1) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(helper(s,t));
    }
}