
package testrt;


public class modelclass1 {
     
    String id,Username,Pass,Phone,Email,Address,Gender;

    public modelclass1(String id, String Username, String Pass, String Phone, String Email, String Address, String Gender) {
        this.id = id;
        this.Username = Username;
        this.Pass = Pass;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
        this.Gender = Gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }
    
}
