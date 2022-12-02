import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HotelChart {

    public static class Customer{
        private int CustomerID;
        private String Name;
        private String Address;
        private Date Birthday;
        private boolean Gender;

        public Customer(){
            ArrayList<Customer> list = new ArrayList<>();
        }

        public Customer(int CustomerID,String Name, String Address, Date Birthday,Boolean Gender){
            this.CustomerID=CustomerID;
            this.Name=Name;
            this.Address=Address;
            this.Birthday=Birthday;
            this.Gender=Gender;
        }

        public int getCustomerID() {
            return CustomerID;
        }

        public void setCustomerID(int customerID) {
            CustomerID = customerID;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String address) {
            Address = address;
        }

        public Date getBirthday() {
            return Birthday;
        }

        public void setBirthday(Date birthday) {
            Birthday = birthday;
        }

        public boolean isGender() {
            return Gender;
        }

        public void setGender(boolean gender) {
            Gender = gender;
        }
    }

    public static class AccountInfo{
        private String email;
        private String password;
        private boolean isAdmin;
        public AccountInfo(String email,String Password,boolean isAdmin){
            this.email=email;
            this.password=password;
            this.isAdmin=isAdmin;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean isAdmin() {
            return isAdmin;
        }

        public void setAdmin(boolean admin) {
            isAdmin = admin;
        }
    }

    public static class Hotel{
        private boolean availability;
        private int customerID;
        private int hotelID;
        private String hotelName;
        private int roomNumber;

        public Hotel(boolean availability, int customerID, int hotelID, String hotelName, int roomNumber) {
            this.availability = availability;
            this.customerID = customerID;
            this.hotelID = hotelID;
            this.hotelName = hotelName;
            this.roomNumber = roomNumber;
        }

        public boolean isAvailability() {
            return availability;
        }

        public void setAvailability(boolean availability) {
            this.availability = availability;
        }

        public int getCustomerID() {
            return customerID;
        }

        public void setCustomerID(int customerID) {
            this.customerID = customerID;
        }

        public int getHotelID() {
            return hotelID;
        }

        public void setHotelID(int hotelID) {
            this.hotelID = hotelID;
        }

        public String getHotelName() {
            return hotelName;
        }

        public void setHotelName(String hotelName) {
            this.hotelName = hotelName;
        }

        public int getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
        }
    }

    public class static Orders{

    }


}
