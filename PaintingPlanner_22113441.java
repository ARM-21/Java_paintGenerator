
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class PaintingPlanner_22113441 {


    public static ArrayList<Paint_22113441> paintDetailsCollector = new ArrayList<>();
    public static ArrayList<House_22113441> houseDetailsCollector = new ArrayList<>();
    public static ArrayList<Address_221133441> addressDetailsCollector = new ArrayList<>();
    public static ArrayList<Room_22113441> roomDetailsCollector = new ArrayList<>();
    public static Boolean exitingChecker = false;

    public static int uniqueHouseIdGenerator() {

            int id = 1;
        boolean found = false;
            do{
//                int houseId =(int)(Math.floor(Math.random()*1000));
                for (House_22113441 house : houseDetailsCollector) {

                    if (house.getHouseId() == id) {
                        found = true;
//                        break;
                    }
                    if (!found) {
                        return id;
                    }
                    id++;
                    found = false;
                }


        }while(found);
            return id;

    }
    public static void paintingDetailsFileReader(String path) {

        try {
            File newfile = new File(path);

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
                    Boolean barcodeTracker = false;
                    if(paintDetailsCollector.size()>0){
                        for(Paint_22113441 paint:paintDetailsCollector) {
                            if(paint.getBarcode().equals(barcode)){
                                barcodeTracker = true;
                            }

                        }
                        if(!barcodeTracker) {
                            Paint_22113441 paintDetails = new Paint_22113441(barcode, brand, color, sheen, pricePerLiter);
                            paintDetailsCollector.add(paintDetails);
                        }
                        }
                    else {
                        Paint_22113441 paintDetails = new Paint_22113441(barcode, brand, color, sheen, pricePerLiter);
                        paintDetailsCollector.add(paintDetails);
                    }

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }catch (Exception ex){
                System.out.println(ex);
            }



    }
    public static void houseDetailsFileReader() {


        try {
            File newfile = new File("src/Houses.txt");

            try {
                Scanner details = new Scanner(newfile);
                while (details.hasNext()) {
                    String[] eachRecord = details.nextLine().split(",");
                        int houseId = Integer.parseInt(eachRecord[0]);
                        double squareMeterPerHour = Double.parseDouble(eachRecord[1]);
                        double squareMeterPerLitre = Double.parseDouble(eachRecord[2]);
                        String notes = eachRecord[3];
                    Boolean houseIdTracer = false;
                    if(houseDetailsCollector.size()>0){
                        for(House_22113441 house:houseDetailsCollector) {
                            if(house.getHouseId() == houseId){
                                houseIdTracer = true;
                            }

                        }
                        if(!houseIdTracer) {
                            House_22113441 houseDetails = new House_22113441(houseId,squareMeterPerHour,squareMeterPerLitre,notes);
                            houseDetailsCollector.add(houseDetails);
                        }
                    }
                    else {
                        House_22113441 houseDetails = new House_22113441(houseId,squareMeterPerHour,squareMeterPerLitre,notes);
                        houseDetailsCollector.add(houseDetails);
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }




    }
    public static void addressDetailsFileReader() {


        try {
            File newfile = new File("src/addresses.txt");

            try {
                Scanner details = new Scanner(newfile);
                while (details.hasNext()) {
                    String[] eachRecord = details.nextLine().split(",");

                        int houseId = Integer.parseInt(eachRecord[0]);
                        String streetNumber = eachRecord[1];
                        String streetName = eachRecord[2];
                        String suburb = eachRecord[3];
                        String state = eachRecord[4];
                        String postCode = eachRecord[5];
                        House_22113441 houseCapturer =null;
                        for(House_22113441 house: houseDetailsCollector){
                            if(house.getHouseId()==houseId){
                                houseCapturer = house;
                            }
                        }
                    Boolean houseIdTracer = false;
                    if(houseDetailsCollector.size()>0){
                        for(Address_221133441 address:addressDetailsCollector) {
                            if(address.getHouseId() == houseId){
                                houseIdTracer = true;
                            }

                        }
                        if(!houseIdTracer) {
                            Address_221133441 addressDetails = new Address_221133441(houseId,houseCapturer.getSquareMetresPerHour(),houseCapturer.getSquareMetresPerLitre(),houseCapturer.getNotes(),streetNumber, streetName,suburb, state,Integer.parseInt(postCode));
                            addressDetailsCollector.add(addressDetails);
                        }
                    }
                    else {
                        Address_221133441 addressDetails = new Address_221133441(houseId,houseCapturer.getSquareMetresPerHour(),houseCapturer.getSquareMetresPerLitre(),houseCapturer.getNotes(),streetNumber, streetName,suburb, state,Integer.parseInt(postCode));
                        addressDetailsCollector.add(addressDetails);
                    }

                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public static void roomDetailsFileReader() {


        try {
            File newfile = new File("src/rooms.txt");

            try {
                Scanner details = new Scanner(newfile);
                while (details.hasNext()) {
                    String[] eachRecord = details.nextLine().split(",");
//                System.out.println(Arrays.toString(eachRecord));

                    int houseId = Integer.parseInt(eachRecord[0]);
                    String description = eachRecord[1];
                    double height = Double.parseDouble(eachRecord[2]);
                    double width = Double.parseDouble(eachRecord[3]);
                    double length = Double.parseDouble(eachRecord[4]);
                    String paintBarcode = eachRecord[5];
                    int numberOfCoats = Integer.parseInt(eachRecord[6]);
                    House_22113441 houseCapturer =null;
                    for(House_22113441 house: houseDetailsCollector){
                        if(house.getHouseId()==houseId){
                            houseCapturer = house;
                        }
                    }
                    Boolean houseIdTracer = false;
                    if(roomDetailsCollector.size()>0){
                        for(Room_22113441 room:roomDetailsCollector) {
                            if(room.getHouseId() == houseId){
                                houseIdTracer = true;
                            }

                        }
                        if(!houseIdTracer) {
                            Room_22113441 roomDetails = new Room_22113441(houseId,description,height,width,length,paintBarcode,numberOfCoats);
                            roomDetailsCollector.add(roomDetails);
                        }
                    }
                    else {
                        Room_22113441 roomDetails = new Room_22113441(houseId,description,height,width,length,paintBarcode,numberOfCoats);
                        roomDetailsCollector.add(roomDetails);
                    }

                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public static void printPaintDetails(ArrayList<Paint_22113441> paintDetailsList) {
        System.out.println("===================================================================================");
        System.out.println("| Barcode        | Brand          | Color           | Sheen          | Price($/L) |");
        System.out.println("===================================================================================");
        paintDetailsCollector.sort(Comparator.comparingDouble(Paint_22113441::getPricePerLiter));
        for (Paint_22113441 paintDetails : paintDetailsList) {
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
    public static Paint_22113441 addNewPaint() {
        Scanner scanner = new Scanner(System.in);
        String barcode;
        String brand;
        String color;
        String sheen;
        double pricePerLiter;
        Boolean barcodeChecker = false;
        do {

            System.out.println("Enter the paint valid barcode of (10 digits): ");
            barcode = scanner.nextLine();
            for(Paint_22113441 barcodeDetail:paintDetailsCollector){
                if(barcode.equals(barcodeDetail.getBarcode())){
                    barcodeChecker = true;
                    System.out.println("Paint already Exists!!");
                    break;
                }
            }

        } while (!(barcode.length() == 10) || barcodeChecker);

        do {
            System.out.println("Enter the paint brand: ");
            brand = scanner.nextLine();
        } while (brand.isEmpty());

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
        return new Paint_22113441(barcode, brand, color, sheen, pricePerLiter);
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
    public static void updatePaintPrice(ArrayList<Paint_22113441> paintDetailsList) {
        Scanner scanner = new Scanner(System.in);
        String barcode;
        double newPricePerLiter;

        // Getting barcode from user to update
        do {
            System.out.println("Enter the barcode of the paint of length 10 to update price: ");
            barcode = scanner.nextLine();
        } while (!(barcode.length() == 10));
        // Searching the paint in the list
        Paint_22113441 paintToUpdate = null;
        for (Paint_22113441 paintDetails : paintDetailsList) {
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
    public static void housePaintingReportGenerator(int enteredHouseId) {

        Scanner scanner = new Scanner(System.in);
        House_22113441 houseCollector = null;
        double totalPaintCost = 0.0;
        double totalHours = 0.0;
        for (House_22113441 house : houseDetailsCollector) {
            if (house.getHouseId() == enteredHouseId) {
                houseCollector = house;
                break;
            }
        }


        if (houseCollector == null) {
            System.out.println("House with ID " + enteredHouseId + " not found.");
            return;
        }
        Address_221133441 addressColector = null;
        for(Address_221133441 address : addressDetailsCollector){
            if(address.getHouseId() == enteredHouseId){
                addressColector = address;
            }
        }
        Room_22113441 roomCollector = null;
        for(Room_22113441 room : roomDetailsCollector){
            if(room.getHouseId() == enteredHouseId){
                roomCollector = room;

            }
        }


        System.out.println("House Painting Report");
        System.out.println("House ID: " + houseCollector.getHouseId());
        System.out.println("Address: " + addressColector.getStreetNumber()+" "+addressColector.getStreetName()+" "+addressColector.getSuburb()+" "+addressColector.getState()+" "+addressColector.getPostcode()); // Assuming Address has a meaningful toString method
        System.out.println("Notes: " + houseCollector.getNotes());
        System.out.println("Estimated square metres per litre of paint: " + houseCollector.getSquareMetresPerLitre());
        System.out.println("Estimated square metres per hour of time: " + houseCollector.getSquareMetresPerHour());
        System.out.println();
        System.out.println("| Description              | Area (m²)| Coats | Area x Coats(m²)|  Paint   | Litres Required| Paint Cost($/L) |TotalPaintCost($)| Hours Needed  |");
        System.out.println("|--------------------------|----------|-------|-----------------|----------|----------------|-----------------|-----------------|---------------|");


        for (Room_22113441 room : roomDetailsCollector) {
            if(room.getHouseId() == enteredHouseId) {
                double roomArea = (room.getLength() * room.getWidth())* (room.getWidth()* room.getHeight()*2)+(room.getLength()* room.getHeight()*2);
                double areaAfterCoats = roomArea * room.getNumberOfCoats();
                double litresRequired =areaAfterCoats/houseCollector.getSquareMetresPerLitre();
                totalPaintCost = totalPaintCost + litresRequired * houseCollector.getSquareMetresPerLitre();
                 totalHours =totalHours + areaAfterCoats/houseCollector.getSquareMetresPerHour();
                Paint_22113441 brandCapturer = null;
                for(Paint_22113441 paint: paintDetailsCollector){
                    if(paint.getBarcode().equals(roomCollector.getPaintBarcode())){
                        brandCapturer = paint;
                    }
                }

                System.out.printf("| %-24s | %8.2f | %4d  | %-15.2f | %-8s | %-14.2f | %-15.2f | %-15.2f | %-13.2f |\n",
                        room.getDescription(), roomArea, room.getNumberOfCoats(), areaAfterCoats, brandCapturer.getBrand(),litresRequired,houseCollector.getSquareMetresPerLitre(),totalPaintCost,totalHours);
            }

        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| Total Paint Cost: $%.2f | Total Hours: %.2f |\n", totalPaintCost, totalHours);


    }
    public static int userInputHouseId() {
        Scanner scan = new Scanner(System.in);
        int userChoice=0;
        do {
            System.out.println("Enter a house id: ");
            ;
            try {
                 userChoice = scan.nextInt();
            }catch (Exception ex){
                System.out.println("Invalid "+ex);
            }
        }while(String.valueOf(userChoice).isEmpty());
        return userChoice;

    }
    public static String addressValidator(String address) {
        Scanner scan = new Scanner(System.in);
        while(address.isEmpty()){
            System.out.println("Enter valid value: ");
            address = scan.nextLine();
        }
        return address;
    }
    public static Boolean barcodeValidator(String barcode) {
        for(Paint_22113441 paint : paintDetailsCollector){
            if(paint.getBarcode().equals(barcode)){
                return true;
            }
        }
        return false;
    }
    public static void addNewHouse() {
        String streetNumber;
        String streetName;
        String suburb;
        String postcode;
        String state;
        double estimatedSqmPerHour;
        double estimatedSqmPerLitre;
        String notes;
        int houseId;

        do{
         houseId = uniqueHouseIdGenerator();}
        while(houseId == 0);
        System.out.println(houseId);
        Scanner scanner = new Scanner(System.in);
        System.out.println(houseId);
        System.out.print("Enter street number: ");
         streetNumber = scanner.nextLine();
         streetNumber = addressValidator(streetNumber);
        System.out.print("Enter street name: ");
         streetName = scanner.nextLine();
         streetName = addressValidator(streetName);
        System.out.print("Enter suburb: ");
         suburb = scanner.nextLine();
         suburb = addressValidator(suburb);
         do {
             System.out.print("Enter postcode of 4 digit: ");
             postcode = scanner.nextLine();
         }while(!(postcode.length() == 4));
         do {
             System.out.print("Enter state(eg:- NSW,QLD,VIC,TAS,SA,NT,WA): ");
             state = scanner.next();
         }while(!(state.toUpperCase().equals("NSW") || state.toUpperCase().equals("QLD") || state.toUpperCase().equals("VIC")||state.toUpperCase().equals("TAS")||state.toUpperCase().equals("SA")||state.toUpperCase().equals("NT")||state.toUpperCase().equals("WA") ));


         do {
             System.out.print("Enter estimated square meters per hour (grater than 0 and less than 10): ");
             estimatedSqmPerHour = scanner.nextDouble();
         }while(!(estimatedSqmPerHour>0 && estimatedSqmPerHour<10));
         do {
             System.out.print("Enter estimated square meters per litre of paint (grater than 0 and less than 10): ");
             estimatedSqmPerLitre = scanner.nextDouble();
             scanner.nextLine();
         }while (!(estimatedSqmPerLitre>0 && estimatedSqmPerLitre<10));
//              scanner.close();

//        Scanner newScanner = new Scanner(System.in);
        System.out.print("Enter any additional notes (e.g. access instructions): ");
        notes = scanner.nextLine();

        System.out.print("Enter the number of rooms: ");
        int numRooms = Integer.parseInt(String.valueOf(scanner.nextLine()));
        String roomDescription,paintBarcode = "";
        double height,width,length;
        int numCoats;
        for (int i = 0; i < numRooms; i++) {
            do {
                System.out.printf("Enter description for room %d: ", i + 1);
                roomDescription = scanner.nextLine();
            }while(roomDescription.isEmpty());
            do {
                System.out.printf("Enter available paint barcode in store for room %d: ", i + 1);
                try{
                paintBarcode = scanner.next();}
                catch (Exception ex){
                    System.out.println("Enter valid value"+ex);
                }
            }while(!(barcodeValidator(paintBarcode)) || paintBarcode.length()!=10);
            do {
                System.out.printf("Enter height of room %d (in meters): ", i + 1);
                height = scanner.nextDouble();
            }while (height < 0);
            do {
                System.out.printf("Enter width of room %d (in meters): ", i + 1);
                width = scanner.nextDouble();
            }while (width<0);
            do {
                System.out.printf("Enter length of room %d (in meters): ", i + 1);
                length = scanner.nextDouble();
            }while (length < 0);
            do{
            System.out.printf("Enter number of coats of paint required for room %d: ", i + 1);
             numCoats = scanner.nextInt();}
            while(numCoats<0);
            scanner.nextLine();


            //adding all the details in our arraylist
            Room_22113441 room = new Room_22113441(houseId,roomDescription, height, width, length,String.valueOf(paintBarcode),numCoats);
            roomDetailsCollector.add(room);
            Address_221133441 address = new Address_221133441(houseId,estimatedSqmPerHour,estimatedSqmPerLitre,notes,streetNumber,streetName, suburb,state, Integer.parseInt(postcode));
            addressDetailsCollector.add(address);
            House_22113441 house = new House_22113441(houseId, estimatedSqmPerHour, estimatedSqmPerLitre, notes);
            houseDetailsCollector.add(house);
            System.out.println("Added Successfully!!");

        }



    }
    public static void saveData() {
        roomDetailsFileReader();
        houseDetailsFileReader();
        paintingDetailsFileReader("src/paints.txt");
        addressDetailsFileReader();
        //for house
        try {
            FileWriter writer = new FileWriter("src/Houses.txt",false);
            for(House_22113441 house:houseDetailsCollector){
            writer.write(house.getHouseId()+","+house.getSquareMetresPerHour()+","+house.getSquareMetresPerLitre()+","+house.getNotes()+"\n");}
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //for paints
        try {
            FileWriter writer = new FileWriter("src/paints.txt",false);
            for(Paint_22113441 paint:paintDetailsCollector){
                writer.write(paint.getBarcode()+","+paint.getBrand()+","+paint.getColor()+","+paint.getSheen()+","+paint.getPricePerLiter()+"\n");}
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //for rooms
        try {
            FileWriter writer = new FileWriter("src/rooms.txt",false);
            for(Room_22113441 room:roomDetailsCollector){
                writer.write(room.getHouseId()+","+room.getDescription()+","+room.getHeight()+","+room.getWidth()+","+room.getLength()+","+room.getPaintBarcode()+","+room.getNumberOfCoats()+"\n");}
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //for address
        try {
            FileWriter writer = new FileWriter("src/addresses.txt",false);
            for(Address_221133441 address:addressDetailsCollector){
                writer.write(address.getHouseId()+","+address.getStreetNumber()+","+address.getStreetName()+","+address.getSuburb()+","+address.getState()+","+address.getPostcode()+"\n");}
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void exitingProgram() {

    }


    public static void main(String[] args) {

        // This code shows a menu and allows the user to choose an option
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("  ____    _         _                    _               _____                      _                 _       \n" +
                " | __ )  (_)  ___  | |__     ___   ___  | |__           |_   _|  _ __    __ _    __| |   ___   _ __  ( )  ___ \n" +
                " |  _ \\  | | / __| | '_ \\   / _ \\ / __| | '_ \\            | |   | '__|  / _` |  / _` |  / _ \\ | '__| |/  / __|\n" +
                " | |_) | | | \\__ \\ | | | | |  __/ \\__ \\ | | | |           | |   | |    | (_| | | (_| | |  __/ | |        \\__ \\\n" +
                " |____/  |_| |___/ |_| |_|  \\___| |___/ |_| |_|  _____    |_|   |_|     \\__,_|  \\__,_|  \\___| |_|        |___/\n" +
                "                                                |_____|                                                       \n");
        roomDetailsFileReader();
        houseDetailsFileReader();
        paintingDetailsFileReader("src/paints.txt");
        addressDetailsFileReader();


        do {
            menuDisplay();
            System.out.print("\nEnter your choice: ");

            // Validate user input
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 to 7.");
                menuDisplay();
                System.out.print("\nEnter your choice: ");
                scanner.next();
            }
            choice = scanner.nextInt();


            switch (choice) {
                case 1:

                    System.out.println("Generating Paint Price Report...");
                    printPaintDetails(paintDetailsCollector);
                    break;
                case 2:

                    System.out.println("Adding a New Paint...");
                    paintDetailsCollector.add(addNewPaint());
                    break;
                case 3:

                    System.out.println("Editing Paint Price....");
                    updatePaintPrice(paintDetailsCollector);
                    break;
                case 4:

                    System.out.println("Generating House Painting Report....");
                    int id = userInputHouseId();
                    housePaintingReportGenerator(id);

                    break;
                case 5:

                    System.out.println("Adding a New House for Painting.....");
                    addNewHouse();
                    break;
                case 6:
                    exitingChecker = true;
                    System.out.println("Saving Data...");
                    saveData();
                    break;
                case 7:
                    Scanner scan = new Scanner(System.in);
                    if(!exitingChecker) {
                        System.out.println("Have you saved your data?? (y/n)");
                        char exitChoice = scan.next().charAt(0);
                        if(exitChoice == 'y' || exitChoice == 'Y'){
                            exitingChecker = true;
                            System.out.println("Exiting program...");
                        }
                        else{
                            exitingChecker = false;
                            choice = 0;
                            System.out.println("Please save your data first|||");
                        }

                    }
                    else{
                        exitingChecker = true;
                    }



                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }while (choice != 7 || !exitingChecker);


    }
}
