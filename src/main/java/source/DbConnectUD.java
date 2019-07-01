package source;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnectUD
{
        public static Connection getConnection() {
            try  {
                Class.forName("org.postgresql.Driver");
                Connection con = DriverManager.getConnection
                        ("jdbc:postgresql://127.0.0.1:5432/udBD","root","1");
                return con;
            }
            catch(Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }

        public static void close(Connection con) {
            try  {
                con.close();
            }
            catch(Exception ex) {
            }
        }
}