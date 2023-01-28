package DataBaseConnection;

import helper.Helper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConnectDataBase {
    private static Connection conn;
    private static Statement stmt;
    private static ResultSet resultSet;
    static String updateDateQuery = "";
    static String updateCaptureDate = "";
    public static String orderNumber = "";

    public static String getNumber(String num) {
        orderNumber = num;
        return orderNumber;
    }

    @BeforeClass
    public static void setUp() {
        final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
//        final String JDBC_Driver = "com.microsoft.jdbc.sqlserver.SqlServerDriver";
//        final String DB_URL = "jdbc:mysql://localhost:3306/test";
//        final String DB_URL = "jdbc:sqlserver://imovingsqlserver.database.windows.net:1433:databaseName=iMovingQa";
        final String DB_URL =
                "jdbc:sqlserver://imovingsqlserver.database.windows.net:1433;"
                        + "database=iMovingQa;"
                        + "user=admin-imoving;"
                        + "password=Q!w2e3r4t5y6;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

        String user = "admin-imoving";
        String password = "Q!w2e3r4t5y6";
        conn = null;
        try {
            Class.forName(JDBC_Driver);
            System.out.println(Helper.color("green") + "Connecting to Database..." + Helper.color("reset"));
            conn = DriverManager.getConnection(DB_URL, user, password);
            if (conn != null) {
                System.out.println(Helper.color("green") + "Connected to the Database..." + Helper.color("reset"));
            }
        } catch (SQLException ex) {
            System.out.println(Helper.color("purple") + "Problem with connecting!!!" + Helper.color("reset"));
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println(Helper.color("black") + "Problem with connecting!!!" + Helper.color("reset"));
            ex.printStackTrace();
        }
    }

    @Test
    public static void updateDate() {
        try {
//            String query = "select * from ImovingOrder";
            stmt = conn.createStatement();
//            resultSet = stmt.executeQuery(query);

            updateDateQuery = "update ImovingOrder\n" +
                    "set MoveDate = dateadd(day, -6, GETDATE())\n" +
//                    "where date(MoveDate)=`"+moveDate+"`";
                    "where Id = ".concat(orderNumber);
            stmt.executeUpdate(updateDateQuery);
            System.out.println(Helper.color("cyan") + "Move date Changed!" + Helper.color("reset"));
//            while(resultSet.next()){
//                int EmpId= resultSet.getInt("EmpId");
//                String EmpName= resultSet.getString("EmpName");
//                String EmpAddress=resultSet.getString(3);
//                String EmpDept=resultSet.getString("EmpDept");
//                Double EmpSal= resultSet.getDouble(5);
//                System.out.println(EmpId+"\t"+EmpName+"\t"+EmpAddress+"\t"+EmpSal+"\t"+EmpDept);
//            }
        } catch (SQLException ex) {
            System.out.println(Helper.color("black") + "Problem with updating move date!!!" + Helper.color("reset"));
            ex.printStackTrace();
        }
    }

    @Test
    public static void oneDayEarlier() {
        try {
            stmt = conn.createStatement();
            updateDateQuery = "update ImovingOrder\n" +
                    "set MoveDate = dateadd(day, -1, GETDATE())\n" +
                    "where Id = ".concat(orderNumber);
            stmt.executeUpdate(updateDateQuery);
            System.out.println(Helper.color("cyan") + "Date changed to one day earlier" + Helper.color("reset"));
        } catch (SQLException ex) {
            System.out.println(Helper.color("black") + "Problem with updating date to one day earlier!!!" + Helper.color("reset"));
            ex.printStackTrace();
        }
    }

    @Test
    public static void changeCaptureDate() {
        try {
            stmt = conn.createStatement();
            updateCaptureDate = "update ScheduledTaskLogItem \n" +
                    "set StartDate = dateadd(day, 0, GETDATE())\n" +
                    "where OrderId = ".concat(orderNumber) + " and TaskName ='Capture'";
            stmt.executeUpdate(updateCaptureDate);
            System.out.println(Helper.color("cyan") + "Capture date updated" + Helper.color("reset"));
        } catch (NullPointerException | SQLException ex) {
            System.out.println(Helper.color("black") + "Problem with updating Capture field!!!" + Helper.color("reset"));
            ex.printStackTrace();
        }
    }

    public static String getDate(int days){
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DATE, -days);
//        String date = dateFormat.format(cal.getTime());

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -days);
        String[] monthNames ={"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String date = dateFormat.format(cal.getTime());
        int month = Integer.parseInt(date.substring(0,2));
        String fullDate = "";
        for (int i = 0; i < monthNames.length;i++){
                fullDate = monthNames[month-1] + date.substring(2);

        }
        return fullDate;
    }


    @AfterClass
    public static void tearDown() {
        if (conn != null) {
            try {
                System.out.println(Helper.color("green")+"Closing Database Connection..."+Helper.color("reset"));
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
