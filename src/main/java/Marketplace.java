package main.java;

        import java.util.Arrays;
        import java.util.Scanner;
public class Marketplace { public static void main(String[] args) {
    int[] productId = {1, 2, 3};
    String[] productName = {"PrA", "PrB", "PrC"};
    double[] productPrice = {2.99, 50.45, 3.0};

    int[] userId = {1, 2, 3};
    String[] userFirstName = {"First1", "First2", "First3"};
    String[] userLastName = {"Last1", "Last2", "Last3"};
    double[] amountofMoney = {1000, 25, 100.5};
    int[][] storedPurchase = new int[3][3];

    Scanner scanforBuy = new Scanner(System.in);
    Scanner scanforMenu = new Scanner(System.in);

    for (; ; ) {
        // Shift menu
        System.out.println("Enter operation from menu (or A or B or C...): ");
        System.out.println("A - Display list of all users;   B - Display list of all Products;  C - Buy after choosing user and product");
        System.out.println("D - Display list of user products by user id;  E - Display list of users that bought product by product id; Q - quit");

        String menuShift = scanforMenu.nextLine();
        if (menuShift.equals("Q")) {
            break;
        }
        switch (menuShift) {
            case "A":
                // Display list of User
                System.out.println("          list of  users ");
                System.out.println("  Id  First Name   Last Name  Amount of Money ");
                for (int i = 0; i <= 2; i++) {
                    System.out.println("   "+userId[i] + "    "+userFirstName[i] + "       "+ userLastName[i]+ "      " + amountofMoney[i]);
                }
                break;
            case "B":
                System.out.println("          list of  products ");
                System.out.println("  Id   Name   Price ");
                for (int i = 0; i <= 2; i++) {
                    System.out.println("   "+productId[i] + "   "+productName[i] + "    "+ productPrice[i]);
                }
                break;
            case "C":
                //Buy
                System.out.print("Enter Id of user who want to buy product: ");
                int idUser = scanforBuy.nextInt();
                System.out.print("Enter Id of product which user want to buy: ");
                int idProduct = scanforBuy.nextInt();

                if (amountofMoney[idUser - 1] > productPrice[idProduct - 1]) {
                    amountofMoney[idUser - 1] = amountofMoney[idUser - 1] - productPrice[idProduct - 1];
                    System.out.println("successful purchase");
                    storedPurchase[idUser - 1][idProduct - 1] = storedPurchase[idProduct - 1][idProduct - 1] + 1;
                }
                break;
            case "D":
                // Display list of user products by user id
                System.out.print("Enter Id  of User for displaying list of user products: ");
                int idUserforDisp = scanforBuy.nextInt();

                for (int i = 0; i <= 2; i++) {
                    if (storedPurchase[idUserforDisp - 1][i] > 0) {
                        System.out.println(productName[i]);
                    }
                }
                break;
            case "E":
                //Display list of users that bought product by product id
                System.out.print("Enter Id of product for displaying of users that bought product: ");
                int idProductforDisp = scanforBuy.nextInt();
                for (int i = 0; i <= 2; i++) {
                    if (storedPurchase[i][idProductforDisp - 1] > 0) {
                        System.out.println(userFirstName[i] + userLastName[i]);
                    }
                }
                break;


        }


    }
}
}
