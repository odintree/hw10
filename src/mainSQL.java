import java.sql.*;

public class mainSQL {

    static final String USER = "root";
    static final String PASS = "123456";
    Statement st = null;
    Connection conn = null;

    private Connection conn() {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbs?useSSL=false", "root", "123456");

        } catch (SQLException se) {

            se.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {

    }

    public void get() throws SQLException {

        this.st = this.conn.createStatement();
        String sql;
        sql = "SELECT * from MOVIES";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            int year = rs.getInt("Year");
            String name = rs.getString("Name");
           

            System.out.print("Name: "+ name);
            System.out.print(", Year: " + year);
        }

        rs.close();
        st.close();
        conn.close();

    }

    public void insert(String name, int year) throws SQLException {
        String sql = "INSERT INTO warehouses(Name,Year) VALUES(?,?)";
        conn.createStatement();
        PreparedStatement pst = conn.prepareStatement(sql);
        try{
            pst.setString(1, name);
            pst.setDouble(2, year);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
