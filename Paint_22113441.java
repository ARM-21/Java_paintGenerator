public class Paint {
    private String barcode;
    private String brand;
    private String color;
    private String sheen;
    private double pricePerLiter;

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSheen(String sheen) {
        this.sheen = sheen;
    }

    public void setPricePerLiter(double pricePerLiter) {
        this.pricePerLiter = pricePerLiter;
    }

    public String getBrand() {
        return brand;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getColor() {
        return color;
    }

    public String getSheen() {
        return sheen;
    }

    public double getPricePerLiter() {
        return pricePerLiter;
    }

    public Paint(String barcode, String brand, String color, String sheen, double pricePerLiter) {
            this.barcode = barcode;
            this.brand = brand;
            this.color = color;
            this.sheen = sheen;
            this.pricePerLiter = pricePerLiter;
        }



}
