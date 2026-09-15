package app;


import service.AllergyChecker;

public class Main {
    public static void main(String[] args) throws Exception {

        AllergyChecker checker = new AllergyChecker();

        String result = checker.checkImage( "C:\\Users\\Aschl\\IdeaProjects\\Portfolio-Project\\src\\main\\resources\\public\\Img\\LabelTwo.jpg" );
        System.out.println("Result:");
        System.out.println(result);
        checker.close();

    }
}