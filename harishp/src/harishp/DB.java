package harishp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DB {
	private String driver = "com.mysql.cj.jdbc.Driver";	
	private String url = "jdbc:mysql://127.0.0.1:3306/hair_db?useSSL=false";	
	private String user = "Hair_GARDEN";	
	private String password = "moving0909@";	
	private Connection connection;
	private static DB instance;
	
	  private DB() {
	        try {
	        	 Class.forName(driver);
	             this.connection = DriverManager.getConnection(url, user, password);
	            // System.out.println("DB 연결 성공!");
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println("DB 연결 실패: " + e.getMessage());
	            throw new RuntimeException("DB 연결 실패", e);
	        }
	  }
	  public static DB getInstance() {
	        if (instance == null) {
	            synchronized (DB.class) { // 스레드 안전
	                if (instance == null) {
	                    instance = new DB();
	                }
	            }
	        }
	        return instance;
	    }
	  public Connection getConnection() {
	        return connection;
	    }
	        

}
