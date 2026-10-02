public class Main {

    public static String error = "";

    public static void main(String[] args)  {
        try {
            System.out.println("Main start!");
            //AsyncService.futureMethod(); // szinkron
            AsyncService.callFuture(); //aszinkron
            System.out.println("Ja");
            Thread.sleep(3000);
            System.out.println("Vége");
        }
        catch (InterruptedException e) { error = e.getMessage(); }




    }
}
