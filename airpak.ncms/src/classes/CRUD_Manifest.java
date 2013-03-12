/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.sql.*;
/**
 *
 * @author Kris
 */
public class CRUD_Manifest{
    
    private static Connection conn;
    private static PreparedStatement statement;
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        String driver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection("localhost\\sqlexpress");
        //Connection conn = database.getConnection();
        return conn;
    }
	
    public static void processException(SQLException e)
    {
       System.err.println("Error Message "+e.getMessage());
       System.err.println("Error Code"+e.getErrorCode());
       System.err.println("SQL State"+e.getSQLState());
    }
  
    public void create(Manifest man) throws Exception{
        statement = conn.prepareStatement("INSERT INTO Manifest"
                + "VALUES(" + man.getId() + ", " 
                            + man.getDriver().getTrn() + ", "
                            + man.getHubAddress() + ")");
        
        statement.executeQuery();
        System.out.println("SQL query executed.");

        for(int i=0; i<man.getAllAgents().size(); i++)
        {
            //add to relation table
            statement = conn.prepareStatement("INSERT INTO Manifest_Agent"
                + "VALUES(" + man.getId() + ", " 
                            + man.getAllAgents().get(i).getTrn() + ")");
            statement.executeQuery();
            System.out.println("SQL query executed.");
        }
    }
    
    public static void read() throws Exception
    {
        statement = conn.prepareCall("{call GetAllManifest()}");
        //PreparedStatement statement = conn.prepareStatement("select * from Manifest");
        ResultSet result = statement.executeQuery();
        System.out.println("SQL query executed.");
        while (result.next())
        {
            System.out.println(
            result.getString(1) + " " + 
            result.getString(2) + " " + 
            result.getString(3) + " " + 
            result.getString(4));
        }
    } 
    
//    cs = this.con.prepareCall("{call SHOW_SUPPLIERS()}");
//    ResultSet rs = cs.executeQuery();
//
//    while (rs.next()) {
//        String supplier = rs.getString("SUP_NAME");
//        String coffee = rs.getString("COF_NAME");
//        System.out.println(supplier + ": " + coffee);
//    }
//    
//    cs = this.con.prepareCall("{call GET_SUPPLIER_OF_COFFEE(?, ?)}");
//    cs.setString(1, coffeeNameArg);
//    cs.registerOutParameter(2, Types.VARCHAR);
//    cs.executeQuery();
//
//    String supplierName = cs.getString(2);
//    
//    cs = this.con.prepareCall("{call RAISE_PRICE(?,?,?)}");
//    cs.setString(1, coffeeNameArg);
//    cs.setFloat(2, maximumPercentageArg);
//    cs.registerOutParameter(3, Types.NUMERIC);
//    cs.setFloat(3, newPriceArg);
//
//    cs.execute();
}
