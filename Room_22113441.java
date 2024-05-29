public class Room_22113441 {
        private int houseId;
        private String description;
        private double height;
        private double width;
        private double length;
        private String paintBarcode;
        private int numberOfCoats;

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public Room_22113441(int houseId, String description, double height, double width, double length, String paintBarcode, int numberOfCoats){
        this.houseId=houseId;
        this.description = description;
        this.height = height;
        this.width = width;
        this.length=length;
        this.paintBarcode = paintBarcode;
        this.numberOfCoats = numberOfCoats;
    }
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getPaintBarcode() {
        return paintBarcode;
    }

    public void setPaintBarcode(String paintBarcode) {
        this.paintBarcode = paintBarcode;
    }

    public int getNumberOfCoats() {
        return numberOfCoats;
    }

    public void setNumberOfCoats(int numberOfCoats) {
        this.numberOfCoats = numberOfCoats;
    }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

}
