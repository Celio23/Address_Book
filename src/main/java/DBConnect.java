import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main (String [] args) {

        try {
            String host = "jdbc:mysql://localhost:3306/pharmacy";
            String uName = "root";
            String uPass = "Celio@123";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            List<UserProfile> profiles = new ArrayList<>();

            Statement stat = con.createStatement();
            String sql = "SELECT member.member_name, member.member_surname, member.cell_num, address.member_address, address.city\n" +
                    "FROM member\n" +
                    "INNER JOIN address\n" +
                    "ON member.id_address = address.id_address \n" +
                    "WHERE address.city = 'JHB'";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                 String member_name = rs.getString("member_name");
                String member_surname = rs.getString("member_surname");
                 long cell_num = rs.getLong("cell_num");
                String member_address = rs.getString("member_address");
                String city = rs.getString("city");

                UserProfile userProfile = new UserProfile(member_name,member_surname,member_address,cell_num,city);
                profiles.add(userProfile);

                String p = member_name + " " + member_surname + " " + cell_num + " " + member_address + " " + city;
                System.out.println(p);
            }

            File file  = new File("Profile.xml");
            ObjectMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File("C:\\Users\\CelioDaPaixao\\Address_Book\\src\\main\\resources\\profile.xml"), profiles);

        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
