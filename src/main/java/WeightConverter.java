
import java.text.DecimalFormat;

import java.text.NumberFormat;

import java.math.RoundingMode;

public class WeightConverter {

    // 1 kg = 2.20462262f pounds

    // 1 pound = 0.45359237 kgs

    public final static float KG_IN_POUNDS = 2.2f;

    public final static float POUNDS_IN_KG = 0.45f;

    public static final String IATA_KG_SYM = "K";

    public static final String IATA_LBS_SYM = "P";

    public static final String KG =  "kg";

    public static final String LBS = "lb";



    private static NumberFormat formatterNoDigit = new DecimalFormat("#.");
    //formatterNoDigit.setRoundingMode(RoundingMode.HALF_UP );
    private static NumberFormat formatterOneDigit = new DecimalFormat("#.#") ;

    private static NumberFormat formatterTwoDigit = new DecimalFormat("#.##") ;

    private static NumberFormat formatterThreeDigit = new DecimalFormat("#.###") ;



    /**

     *  returns float value

     * @param fltValue , no of digits to round

     * @return

     */



    public static float round(float fltValue,int precision){

        try{

            if(precision == 0)

                return Float.parseFloat(formatterNoDigit.format(fltValue));

            else if(precision == 1)

                return Float.parseFloat(formatterOneDigit.format(fltValue));

            else if(precision == 2)

                return Float.parseFloat(formatterTwoDigit.format(fltValue));

            else

                return Float.parseFloat(formatterThreeDigit.format(fltValue));

        }

        catch(Exception exp){

            return 0.0f;

        }

    }



    /**

     * returns as float to 1 digit

     * @param fltValue

     * @return

     */



    public static float round(float fltValue){

        return round(fltValue,1);

    }





    /**

     *  returns float value as string. For LB we round up to whole num. No ounces are displayed after decimal dot

     *  this method will return emptry string in case of exception

     * @param fltValue , no of digits to round

     * @return

     */

    public static String roundAsLBsString(float fltValue, int precision){
        // current requirement is to round up to a whole number in pounds.
        // no ounces calculation.  Func signature remains the same
        // in case current can change in the future.
        try {
            DecimalFormat decimalFormat = new DecimalFormat("#.");
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            NumberFormat numberFormat = decimalFormat;
            Float returnVal = Float.parseFloat(numberFormat.format(fltValue));

            return returnVal.toString();
        } catch (Exception ex){
            return "0.0";
            }

        //  return Float.parseFloat(formatterNoDigit.format(fltValue));



        //val f = DecimalFormat("#.##").apply { roundingMode = RoundingMode.HALF_UP }

        //String lbString= round(fltValue,precision)+"";
        //return lbString.substring(0, lbString.lastIndexOf("."));

    }



    /**

     *  returns float value as string

     *  this method will return emptry string in case of exception

     * @param fltValue , no of digits to round

     * @return

     */



    public static String roundAsString(float fltValue,int precision){

        return round(fltValue,precision)+"";

    }



    /**

     *  returns float value as string

     *  this method will return emptry string in case of exception

     * @param fltValue , no of digits to round

     * @return

     */



    public static String roundAsString(float fltValue){

        return round(fltValue,2)+"";

    }



    /**

     *  use this method if you want to display emptry string in case of zero or null value

     *  returns float value as string

     *  this method will return emptry string in case of exception

     * @param fltValue , no of digits to round

     * @return

     */



    public static String roundAsString(float fltValue,boolean valCanBeZero){

        if (valCanBeZero && fltValue < 0.05)

            return "";

        return round(fltValue,1)+"";

    }





    /**

     *  this method converts kgs into pounds

     *  value will be returned to one digit precision

     * @param weight in kilgo gram

     * @return

     */

    public static float toPound(float kg){

        return  round(KG_IN_POUNDS*kg);

    }



    /**

     * this method converts kgs into pounds

     * @param kg ,precision

     * @return

     */

    public static float toPound(float kg,int precision){

        return round(KG_IN_POUNDS*kg,precision);

    }



    /**

     *  this method converts kgs to pounds as string value

     * @param kg

     * @return

     */

    public static String toPoundAsString(float kg){

        return roundAsString(KG_IN_POUNDS*kg);

    }









    /**

     * method changes kg to pound

     * @param kg ,precision

     * @return

     */

    public static String toPoundAsString(float kg,int precision){

        return roundAsString(KG_IN_POUNDS*kg,precision);

    }





    /**

     * method changes kg to pound

     * @param kg ,precision

     * @return

     */

    public static String toPoundAsString(float kg,boolean valCanBeZero){

        return roundAsString(KG_IN_POUNDS*kg,valCanBeZero);

    }





    /**

     *

     * @param lbs

     * @returns pound in kgs

     */

    public static  float toKg(float lbs){

        return round(lbs/KG_IN_POUNDS);

    }



    /**

     *

     * @param kg ,precision

     * @returns pound in kgs

     */

    public static float toKg(float lbs,int precision){

        return round(lbs/KG_IN_POUNDS,precision);

    }



    /**

     *

     * @param kg

     * @returns pound in kgs

     */

    public static String toKgAsString(float lbs){

        return roundAsString(lbs/KG_IN_POUNDS);

    }



    /**

     *

     * @param kg ,precision

     * @returns pound in kgs

     */

    public static String toKgAsString(float lbs,int precision){

        return roundAsString(lbs/KG_IN_POUNDS,precision);

    }



    /**

     *

     * @param args

     */



    public static void main(String[] args) {

        // test round

        System.out.println(" For 1.5f expected 2, actual result :   "+ roundAsLBsString(1.5f, 0));
        System.out.println(" For 1.4f expected 1, actual result :   "+ roundAsLBsString(1.4f, 0));
        System.out.println(" For 2.5f expected 3, actual result :   "+ roundAsLBsString(2.5f, 0));
        System.out.println(" For 2.4f expected 2, actual result :   "+ roundAsLBsString(2.4f, 0));
        System.out.println(" For 0 expected 0.0, actual result :   "+ roundAsLBsString(0, 0));

//    	  System.out.println(round(16f));

//        System.out.println(round(16.1678f));

//        System.out.println(round(16.1311f,2));

//        System.out.println(roundAsString(16.1678f));

//        System.out.println(roundAsString(16.1311f,2));

//        System.out.println("-------------");

//

//        System.out.println(toPound(1f));

//        System.out.println(toPound(99.996f));

//        System.out.println(toPound(99.996f,2));

//        System.out.println(1f*2.2);

//        System.out.println(99.996f*2.2);

//        System.out.println(toPoundAsString(1f));

//        System.out.println(toPoundAsString(99.996f,1));

//        System.out.println(1f*2.2);

//        System.out.println(99.996f*2.2);

//        System.out.println("-------------");

//

//        System.out.println(toKg(1f));

//        System.out.println(toKg(219.99f));

//        System.out.println(toKg(219.99f,2));

//        System.out.println(2.2f/2.2);

//        System.out.println(219.99f/2.2);

//        System.out.println(toKgAsString(2.2f));

//        System.out.println(toKgAsString(219.99f,1));

//        System.out.println(toKgAsString(219.99f,2));

 //       System.out.println("-----"+roundAsString(0.05f,true));

    }



}
