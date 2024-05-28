
import java.io.File;
import java.util.*;

public class MainMenu {


public static ArrayList<DetailsOfPaint> paintDetailsCollector = new ArrayList<>();


    public static void paintingDetailsFileReader() {


        try {
            File newfile = new File("src/paints.txt");

        try {
            Scanner details = new Scanner(newfile);
            while (details.hasNext()) {
            String[] eachRecord = details.nextLine().split(",");
//                System.out.println(Arrays.toString(eachRecord));
                String barcode = eachRecord[0];
                String brand = eachRecord[1];
                String color = eachRecord[2];
                String sheen = eachRecord[3];
                double pricePerLiter = Double.parseDouble(eachRecord[4]);
                DetailsOfPaint paintDetails = new DetailsOfPaint(barcode, brand, color, sheen, pricePerLiter);
                paintDetailsCollector.add(paintDetails);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }catch (Exception ex){
                System.out.println(ex);
            }



    }

    public static void printPaintDetails(ArrayList<DetailsOfPaint> paintDetailsList) {
        System.out.println("===================================================================================");
        System.out.println("| Barcode        | Brand          | Color           | Sheen          | Price($/L) |");
        System.out.println("===================================================================================");
        paintDetailsCollector.sort(Comparator.comparingDouble(DetailsOfPaint::getPricePerLiter));
        for (DetailsOfPaint paintDetails : paintDetailsList) {
            // Format output for each column with fixed width
            System.out.printf("| %-13s | %-15s | %-15s | %-14s |   %-4.2f    |\n",
                    paintDetails.getBarcode(),
                    paintDetails.getBrand(),
                    paintDetails.getColor(),
                    paintDetails.getSheen(),
                    paintDetails.getPricePerLiter());
        }

        System.out.println("===================================================================================");
    }
    public static DetailsOfPaint addNewPaint() {
        Scanner scanner = new Scanner(System.in);
        String barcode;
        String brand;
        String color;
        String sheen;
        double pricePerLiter;
        Boolean barcodeChecker = false;
        // Barcode input with validation
        do {

            System.out.println("Enter the paint valid barcode of (10 digits): ");
            barcode = scanner.nextLine();
            for(DetailsOfPaint barcodeDetail:paintDetailsCollector){
                if(barcode.equals(barcodeDetail.getBarcode())){
                    barcodeChecker = true;
                    System.out.println("Paint already Exists!!");
                    break;
                }
            }

        } while (!(barcode.length() == 10) || barcodeChecker); // Ensures exactly 10 digits



        // Brand input with validation (non-empty)
        do {
            System.out.println("Enter the paint brand: ");
            brand = scanner.nextLine();
        } while (brand.isEmpty());

        // Color input with validation (non-empty)
        do {
            System.out.println("Enter the paint color: ");
            color = scanner.nextLine();
        } while (color.isEmpty());

        // Sheen input with validation (non-empty)
        do {
            System.out.println("Enter the paint sheen : ");
            sheen = scanner.nextLine();
        } while (sheen.isEmpty());

        // Price per liter input with validation (positive number)
        do {
            System.out.println("Enter the price per liter ($): ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number: ");
                scanner.next(); // Clear scanner buffer
            }
            pricePerLiter = scanner.nextDouble();
        } while (pricePerLiter <= 0); // Ensures price is positive

        // Create and return PaintDetails object
        return new DetailsOfPaint(barcode, brand, color, sheen, pricePerLiter);
    }

    public static void menuDisplay() {
        System.out.println("\nMain Menu");
        System.out.println("1. Generate Paint Price Report");
        System.out.println("2. Add a New Paint");
        System.out.println("3. Edit Paint Price");
        System.out.println("4. Generate House Painting Report");
        System.out.println("5. Add a New House for Painting");
        System.out.println("6. Save Data");
        System.out.println("7. Exit Program");
    }

    public static void updatePaintPrice(ArrayList<DetailsOfPaint> paintDetailsList) {
        Scanner scanner = new Scanner(System.in);
        String barcode;
        double newPricePerLiter;

        // Getting barcode from user to update
        do {
            System.out.println("Enter the barcode of the paint of length 10 to update price: ");
            barcode = scanner.nextLine();
        } while (!(barcode.length() == 10));
        // Searching the paint in the list
        DetailsOfPaint paintToUpdate = null;
        for (DetailsOfPaint paintDetails : paintDetailsList) {
            if (paintDetails.getBarcode().equals(barcode)) {
                paintToUpdate = paintDetails;
                break;
            }
        }

        // if paint is not found
        if (paintToUpdate == null) {
            System.out.println("Paint with barcode " + barcode + " not found.");
            return;
        }
        else{
            System.out.println("Paint Found!!");
            System.out.println("Barcode = "+paintToUpdate.getBarcode()+"\nBrand = "+paintToUpdate.getBrand());
            System.out.println("color = "+paintToUpdate.getColor()+"\nSheen = "+paintToUpdate.getSheen());
            System.out.println("Price = "+paintToUpdate.getPricePerLiter());

        }

        // Get and validate new price
        do {
            System.out.println("Enter the new price per liter ($): ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number: ");
                scanner.next();
            }
            newPricePerLiter = scanner.nextDouble();
        } while (newPricePerLiter <= 0); // Ensures price is positive

        paintToUpdate.setPricePerLiter(newPricePerLiter);
        System.out.println("Price for paint " + barcode + " updated to $" + newPricePerLiter + " per liter.");
    }



    public static void main(String[] args) {

        // This code shows a menu and allows the user to choose an option
        Scanner scanner = new Scanner(System.in);
        int choice;

        paintingDetailsFileReader();
        do {
            menuDisplay();
            System.out.print("Enter your choice: ");

            // Validate user input
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 to 7.");
                menuDisplay();
                System.out.print("Enter your choice: ");
                scanner.next();
            }
            choice = scanner.nextInt();

            // Perform actions based on user choice
            switch (choice) {
                case 1:
                    // Generate Paint Price Report
                    System.out.println("Generating Paint Price Report...");
                    printPaintDetails(paintDetailsCollector);
                    break;
                case 2:
                    // Add a New Paint

                    System.out.println("Adding a New Paint...");
                    paintDetailsCollector.add(addNewPaint());
                    break;
                case 3:
                    // Edit Paint Price
                    System.out.println("Editing Paint Price....");
                    updatePaintPrice(paintDetailsCollector);
                    break;
                case 4:
                    // Generate House Painting Report
                    System.out.println("Generating House Painting Report....");

                    break;
                case 5:
                    // Add a New House for Painting
                    System.out.println("Adding a New House for Painting.....");
                    break;
                case 6:
                    // Save Data
                    System.out.println("Saving Data...");
                    break;
                case 7:
                    // Exit Program
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 7);


    }
}
