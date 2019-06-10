package press.data;

import java.sql.*;
import java.util.*;

import press.business.*;

public class ProductDB {

    //This method returns null if a product isn't found.
    public static Product selectProduct(String productCode) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Product "
                + "WHERE ProductCode = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, productCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setId(rs.getLong("ProductID"));
                p.setCode(rs.getString("ProductCode"));
                
                p.setGarmentType(rs.getString("GarmentType"));
                p.setGarmentSize(rs.getString("GarmentSize"));
                p.setGarmentColor(rs.getString("GarmentColor"));
                p.setForegroundTwill(rs.getString("ForegroundTwill"));
                p.setForegroundStitch(rs.getString("ForegroundStitch"));
                p.setBackgroundTwill(rs.getString("BackgroundTwill"));
                p.setBackgroundStitch(rs.getString("BackgroundStitch"));
                p.setStitchingFontFront(rs.getString("StitchingFontFront"));
                p.setStitchingColorFront(rs.getString("StitchingColorFront"));
                p.setStitchingFontBack(rs.getString("StitchingFontBack"));
                p.setStitchingColorBack(rs.getString("StitchingColorBack"));
                p.setStitchingFontLeft(rs.getString("StitchingFontLeft"));
                p.setStitchingColorLeft(rs.getString("StitchingColorLeft"));
                p.setStitchingFontRight(rs.getString("StitchingFontRight"));
                p.setStitchingColorRight(rs.getString("StitchingColorRight"));
                p.setStitchingFontHood(rs.getString("StitchingFontHood"));
                p.setStitchingColorHood(rs.getString("StitchingColorHood"));
                
                p.setPrice(rs.getDouble("ProductPrice"));
                return p;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    //This method returns null if a product isn't found.
    public static Product selectProduct(long productID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Product "
                + "WHERE ProductID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setLong(1, productID);
            rs = ps.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setId(rs.getLong("ProductID"));
                p.setCode(rs.getString("ProductCode"));
                
                p.setGarmentType(rs.getString("GarmentType"));
                p.setGarmentSize(rs.getString("GarmentSize"));
                p.setGarmentColor(rs.getString("GarmentColor"));
                p.setForegroundTwill(rs.getString("ForegroundTwill"));
                p.setForegroundStitch(rs.getString("ForegroundStitch"));
                p.setBackgroundTwill(rs.getString("BackgroundTwill"));
                p.setBackgroundStitch(rs.getString("BackgroundStitch"));
                p.setStitchingFontFront(rs.getString("StitchingFontFront"));
                p.setStitchingColorFront(rs.getString("StitchingColorFront"));
                p.setStitchingFontBack(rs.getString("StitchingFontBack"));
                p.setStitchingColorBack(rs.getString("StitchingColorBack"));
                p.setStitchingFontLeft(rs.getString("StitchingFontLeft"));
                p.setStitchingColorLeft(rs.getString("StitchingColorLeft"));
                p.setStitchingFontRight(rs.getString("StitchingFontRight"));
                p.setStitchingColorRight(rs.getString("StitchingColorRight"));
                p.setStitchingFontHood(rs.getString("StitchingFontHood"));
                p.setStitchingColorHood(rs.getString("StitchingColorHood"));
                
                p.setPrice(rs.getDouble("ProductPrice"));
                return p;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    //This method returns null if a product isn't found.
    public static List<Product> selectProducts() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Product";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Product> products = new ArrayList<>();
            while (rs.next()) {
                Product p = new Product();
                p.setCode(rs.getString("ProductCode"));
                
                p.setGarmentType(rs.getString("GarmentType"));
                p.setGarmentSize(rs.getString("GarmentSize"));
                p.setGarmentColor(rs.getString("GarmentColor"));
                p.setForegroundTwill(rs.getString("ForegroundTwill"));
                p.setForegroundStitch(rs.getString("ForegroundStitch"));
                p.setBackgroundTwill(rs.getString("BackgroundTwill"));
                p.setBackgroundStitch(rs.getString("BackgroundStitch"));
                p.setStitchingFontFront(rs.getString("StitchingFontFront"));
                p.setStitchingColorFront(rs.getString("StitchingColorFront"));
                p.setStitchingFontBack(rs.getString("StitchingFontBack"));
                p.setStitchingColorBack(rs.getString("StitchingColorBack"));
                p.setStitchingFontLeft(rs.getString("StitchingFontLeft"));
                p.setStitchingColorLeft(rs.getString("StitchingColorLeft"));
                p.setStitchingFontRight(rs.getString("StitchingFontRight"));
                p.setStitchingColorRight(rs.getString("StitchingColorRight"));
                p.setStitchingFontHood(rs.getString("StitchingFontHood"));
                p.setStitchingColorHood(rs.getString("StitchingColorHood"));
                
                p.setPrice(rs.getDouble("ProductPrice"));
                products.add(p);
            }
            return products;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}