public class House {
        private String houseId; // Assuming a unique identifier for the house
        private double squareMetresPerHour; // Purpose unclear without context
        private double squareMetresPerLitre; // Purpose unclear without context
        private String notes;
        private Address address; // Has-a relationship with Address class

        // Getters, setters, and constructor (omitted for brevity)

        public String getHouseId() {
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

    public void setHouseId(String houseId) {
            this.houseId = houseId;
        }

        // Similar methods for other fields

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }


}
