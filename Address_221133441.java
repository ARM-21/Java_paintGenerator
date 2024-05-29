public class Address_221133441 extends House_22113441 {

        private int houseId;
        private String streetNumber;
        private String streetName;
        private String suburb;
        private String state;
        private int postCode;

     public Address_221133441(int houseId,double squarePerHour,double squarePerLiter,String notes,String streetNumber,String streetName,String suburb,String state,int postCode){
         super(houseId,squarePerHour,squarePerHour,notes);
            this.houseId = houseId;
            this.streetNumber = streetNumber;
            this.streetName = streetName;
            this.suburb = suburb;
            this.state = state;
            this.postCode = postCode;
        }
    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public int getPostcode() {
        return postCode;
    }

    public void setPostcode(int postcode) {
        this.postCode = postcode;
    }

    public String getStreetNumber() {
            return streetNumber;
        }
        public void setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
        }



}
