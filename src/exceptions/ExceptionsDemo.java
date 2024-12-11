package exceptions;

public class ExceptionsDemo {
    public static void main(String[] args) {
        try{
            System.out.println(checkAge(20));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("finally");
        }
    }

    public static String checkAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("under age : access denied");
        }else{
            return "Access Granted";
        }
    }
}
