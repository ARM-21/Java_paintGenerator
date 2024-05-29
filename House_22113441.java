public class House_22113441 {
        private int houseId;
        private double squareMetresPerHour;
        private double squareMetresPerLitre;
        private String notes;

        // Getters, setters, and constructor
      public House_22113441(int houseId, double squareMetersPerHour, double squareMetersPerLitre, String notes) {
            this.houseId = houseId;
            this.squareMetresPerHour = squareMetersPerHour;
            this.squareMetresPerLitre = squareMetersPerLitre;
            this.notes = notes;
        }

    public int getHouseId() {
            return houseId;
        }

    public double getSquareMetresPerHour() {
        return squareMetresPerHour;
    }

    public void setSquareMetresPerHour(double squareMetresPerHour) {
        this.squareMetresPerHour = squareMetresPerHour;
    }

    public double getSquareMetresPerLitre() {
        return squareMetresPerLitre;
    }

    public void setSquareMetresPerLitre(double squareMetresPerLitre) {
        this.squareMetresPerLitre = squareMetresPerLitre;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }


}
