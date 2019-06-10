package press.data;

import java.sql.*;

import press.business.*;

public class UserDB {

    public static void insert(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query
                = "INSERT INTO User (Name, Email, OrganizationName, "
                + "Address1, Address2, City, State, Zip, Country, "
                + "CreditCardType, CreditCardNumber, CreditCardExpirationDate) "
                + "VALUES (?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, "
                + "?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getOrganizationName());
            ps.setString(4, user.getAddress1());
            ps.setString(5, user.getAddress2());
            ps.setString(6, user.getCity());
            ps.setString(7, user.getState());
            ps.setString(8, user.getZip());
            ps.setString(9, user.getCountry());
            ps.setString(10, user.getCreditCardType());
            ps.setString(11, user.getCreditCardNumber());
            ps.setString(12, user.getCreditCardExpirationDate());
            
            ps.executeUpdate();
            
            //Get the user ID from the last INSERT statement.
            String identityQuery = "SELECT @@IDENTITY AS IDENTITY";
            Statement identityStatement = connection.createStatement();
            ResultSet identityResultSet = identityStatement.executeQuery(identityQuery);
            identityResultSet.next();
            long userID = identityResultSet.getLong("IDENTITY");
            identityResultSet.close();
            identityStatement.close();

            // Set the user ID in the User object
            user.setId(userID);
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static void update(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "UPDATE User SET "
                + "Name = ?, "
                + "OrganizationName = ?, "
                + "Address1 = ?, "
                + "Address2 = ?, "
                + "City = ?, "
                + "St = ?, "
                + "Zip = ?, "
                + "Country = ?, "
                + "CreditCardType = ?, "
                + "CreditCardNumber = ?, "
                + "CreditCardExpirationDate = ? "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getOrganizationName());
            ps.setString(3, user.getAddress1());
            ps.setString(4, user.getAddress2());
            ps.setString(5, user.getCity());
            ps.setString(6, user.getState());
            ps.setString(7, user.getZip());
            ps.setString(8, user.getCountry());
            ps.setString(9, user.getCreditCardType());
            ps.setString(10, user.getCreditCardNumber());
            ps.setString(11, user.getCreditCardExpirationDate());
            ps.setString(12, user.getEmail());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static User selectUser(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM User "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setId(rs.getLong("UserID"));
                user.setName(rs.getString("Name"));
                user.setEmail(rs.getString("Email"));
                user.setOrganizationName(rs.getString("OrganizationName"));
                user.setAddress1(rs.getString("Address1"));
                user.setAddress2(rs.getString("Address2"));
                user.setCity(rs.getString("City"));
                user.setState(rs.getString("State"));
                user.setZip(rs.getString("Zip"));
                user.setCountry(rs.getString("Country"));
                user.setCreditCardType(rs.getString("CreditCardType"));
                user.setCreditCardNumber(rs.getString("CreditCardNumber"));
                user.setCreditCardExpirationDate(rs.getString("CreditCardExpirationDate"));
            }
            return user;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static boolean emailExists(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT Email FROM User "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }    
}