public class ExceptionExample {

    public static void main(String[] args) {

        try {
            //loop begins
            for (int i = 5; i >= 1; i--) {
                System.out.println(10 / i);

                Integer.parseInt("a");
                getValue("t");
                //if you want above statement to  cause exception and fail the program
                //you have to catch specific exception for divide by zero and leave number format exception
                //don't catch Exception-> which is a broad one
            }//end of for loop
        }catch(ArithmeticException a ){
            System.out.println("Arithmetic exception: " + a.getMessage());

        }catch(NumberFormatException n){
            System.out.println("Number format exception " + n.getMessage());
        }finally{
            //cleanup code goes
            System.out.println("clean up code goes here");
        }

//        try{
//            //run your code where you are expecting an exception
//        }catch(//name of the exception){
//           //handle your exception- you do something about your exception
//        }
    }

    public static int getValue(String s) throws NumberFormatException{
        //either you handle NumberFormatException which thrown by Integer.parseInt() or
        //throw it to the consumers of this method
//        try {
//            int i = Integer.parseInt(s);
//        }catch(NumberFormatException n){
//            //handle
//        }
        int i = Integer.parseInt(s);
        return  i;

    }

}
