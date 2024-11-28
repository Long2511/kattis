package Week4.Task1;

public class StringDemo {
    public static void main(String[] args) {
        String str = "Java Programming";

        String str2 = str + " is fun!";
        System.out.println(str2);
        System.out.println("Substring: " + str.substring(5, 16));
        System.out.println("Length: " + str.length());
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println(str.concat("Testttttt"));
        System.out.println("Length: " + str.length());
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Substring (5 to 15): " + str.substring(5, 15));
        System.out.println("Contains 'gram': " + str.contains("gram"));
    }
}
