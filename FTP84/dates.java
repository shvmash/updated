import java.util.Date;
import java.text.SimpleDateFormat;
class dates{
   public static void main(String args[]){
	 SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
	 String dateBeforeString = "31 01 2014";
	 String dateAfterString = "02 02 2014";

	 try {
	       Date dateBefore = myFormat.parse(dateBeforeString);
	       Date dateAfter = myFormat.parse(dateAfterString);
	       long difference = dateAfter.getTime() - dateBefore.getTime();
	       float daysBetween = (difference / (1000*60*60*24));
               /* You can also convert the milliseconds to days using this method
                * float daysBetween = 
                *         TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS)
                */
	       System.out.println("Number of Days between dates: "+daysBetween);
	 } catch (Exception e) {
	       e.printStackTrace();
	 }
   }
}