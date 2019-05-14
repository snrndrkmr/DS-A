import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
public class RoughWork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int top=-1; int x = 0; int max =1000; int a[] = new int[max];
		 * System.out.println(a[++top]=x); int b=1; System.out.println( top << 1);
		 */
		/*
		 * Palindrome("malayalam"); Palindrome("narendra");
		 */
		/*System.out.println(dayOfProgrammer(2017));*/
		int[] a =new int[] {1,4,3,2};
		reverseArray(a);
		NumberFormat nf = NumberFormat.getInstance();
		nf.getCurrency().getSymbol();
	}

	public static String Palindrome(String name) {
		String s1 = "";
		for (int i = name.length() - 1; i >= 0; i--) {
			s1 = s1 + name.charAt(i);

		}
		if (name.equals(s1)) {
			System.out.println("string is palindrome " + name + " " + s1);
		} else {
			System.out.println("string is not a palindrome " + name + " " + s1);
		}
		return name;
	}
	static int[] reverseArray(int[] a) {
		int[] b=new int[a.length];
        for(int i=a.length-1;i>=0;i--){
            System.out.print(a[i]+" ");
            b[i]=a[i];
        }
    return b;
    }

	static String dayOfProgrammer(int year) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		int d = 243;
		if (year >= 1700 && year<= 1917) {
			if (year % 4 == 0) {
				d = 244;
			}
		} else if (year >= 1919 && year <= 2700) {
			if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
				d = 244;
			}
		} else if (year == 1918) {
			d = 230;
		}
		int r = 256 - d;
		String date = r + "." + 9 + "." + year;
		/*System.out.println(sdf.format(sdf.parse(date)));*/
		return date;
	}
static void bonAppetit(List<Integer> bill, int k, int b) {
	int total=0;
       for(int i=0;i<bill.size();i++) {
    	   if(bill.get(i)!=k) {
    		   /*System.out.println(bill.get(i));*/
    		   total= total+bill.get(i);
    		   if(b==total/2) {
    			  System.out.println(b+" "+total+" "+"Bon Apetite"); 
    		   }
    	   }
    	   if(bill.get(i)==k) {
    		   total= total+bill.get(i);
    		   System.out.println("------------------------");
    		   System.out.println(bill.get(i));
    		   b=total/2;
    		   System.out.println(b+" "+total+" "+"Not Bon Apetite");
    	   }
    	   
       }

    }
}
