package string_operations;



import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JTextField;

public class Stringoperations {

    public static double longestCommonSubsequence(String A, String B) {

        int[][] mat = new int[A.length() + 1][B.length() + 1];

        A = " " + A;
        B = " " + B;

        for (int i = 1; i < A.length(); i++) {
            for (int j = 1; j < B.length(); j++) {

                if (A.charAt(i) == B.charAt(j)) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                } else {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }

        int P = mat[A.length() - 1][B.length() - 1];
        int T = Math.max(A.length() - 1, B.length() - 1);

        return (double) (P * 100) / T;

    }

   public static boolean isSubstring(String A, String B) {

        int base = 311;
        String lowest = A;
        String longest = B;
        long Hash = 0;

        int minLength = lowest.length();

        for (int i = 0; i < minLength; i++) {
            Hash = Hash * base + (lowest.charAt(i) - 'a' + 1);
        }

        long Hash2 = 0;

        for (int i = 0; i < longest.length(); i++) {
            Hash2 = Hash2 * base + (longest.charAt(i) - 'a' + 1);

            if (i >= minLength - 1) {
                if (Hash == Hash2) {
                    return true;
                }

                Hash2 = Hash2 - ((longest.charAt(i - minLength + 1) - 'a' + 1) * (long) (Math.pow(base, minLength - 1)));
            }
        }
        return false;
    }
    
    
    public static void eraseNumber(char X, JTextField text) {
      
          if (X == KeyEvent.CHAR_UNDEFINED || X == '\b'
                || X == '\n') {
            return;
        }
        
        Vector<Character> v = new Vector<>();
        v.add('0');
        v.add('1');
        v.add('2');
        v.add('3');
        v.add('4');
        v.add('5');
        v.add('6');
        v.add('7');
        v.add('8');
        v.add('9');
        
        if(v.contains(X)){
        String Xs = text.getText();
        int t;

            do {
                t = Xs.indexOf(X + "");
                if (t == -1) {
                    break;
                }
                String x1 = Xs.substring(0, t);
                String x2 = Xs.substring(t + 1);
                Xs = x1 + x2;
                text.setText(Xs);
            } while (true);
        }        
    }
    
    
     public static void eraseLetter(char X, JTextField text) {
        if (X == KeyEvent.CHAR_UNDEFINED || X == '\b'
                || X == '\n') {
            return;
        }

        String Xs = text.getText();
        int t;
        try {
            var x = Integer.parseInt("" + X);
        } catch (NumberFormatException e) {
            do {
                t = Xs.indexOf(X + "");
                if (t == -1) {
                    break;
                }
                String x1 = Xs.substring(0, t);
                String x2 = Xs.substring(t + 1);
                Xs = x1 + x2;
                text.setText(Xs);
            } while (true);
        }

    }
     
     public static boolean isCorrectIdentification(String CIT){
         
         if(CIT.length() != 11){
             return false;
         }
         String year = CIT.substring(0, 2);
         String month = CIT.substring(2, 4);
         String day = CIT.substring(4, 6);
         String century = CIT.substring(6, 7);
         int centuryN = Integer.parseInt(century);
         if(centuryN >= 5 && centuryN <= 7){
             year = "20" + year;
         }
         else if(centuryN >= 1 && centuryN <= 4){
             year = "19" + year;
         }
         else{
             return false;
         }
         
         int actualYear = Calendar.getInstance().get(1);
         int diference = actualYear - Integer.parseInt(year);
         if(diference <= 16){
             return false;
         }
         
         int monthN = Integer.parseInt(month);
         int dayN = Integer.parseInt(day);
         if(dayN <= 0){
             return false;
         }
         if(monthN <= 0 || monthN > 12){
             return false;
         }
         else{
             switch (monthN) {
                 case 2 -> {
                     if(dayN > 28){
                         return false;
                     }
                 }
                 case 4, 6, 9, 11 -> {
                     if(dayN > 30){
                         return false;
                     }
                 }
                 default -> {
                     if(dayN > 31){
                         return false;
                     }
                 }
             }
         }
         
         return true;
     }
}
