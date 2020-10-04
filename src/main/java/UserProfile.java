public class UserProfile {
    String member_name;
    String member_surname;
    String member_address;
    long cell_num;
    String city;

    public UserProfile(String member_name, String member_surname, String member_address, long cell_num, String city) {
        this.member_name = member_name;
        this.member_surname = member_surname;
        this.member_address = member_address;
        this.cell_num = cell_num;
        this.city = city;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_surname() {
        return member_surname;
    }

    public void setMember_surname(String member_surname) {
        this.member_surname = member_surname;
    }

    public String getMember_address() {
        return member_address;
    }

    public void setMember_address(String member_address) {
        this.member_address = member_address;
    }

    public long getCell_num() {
        return cell_num;
    }

    public void setCell_num(long cell_num) {
        this.cell_num = cell_num;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}