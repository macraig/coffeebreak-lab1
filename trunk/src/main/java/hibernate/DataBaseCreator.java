package hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.Location;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import model.User;
import model.Place;

public class DataBaseCreator {

	public static void createDatabase() {
//		try {
//			Class.forName("org.hsqldb.jdbcDriver");
//			Connection c = DriverManager.getConnection("jdbc:hsqldb:file:myPhysicsDB", "sa", "");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}		
		Configuration cfg = new AnnotationConfiguration().configure("/hibernate.cfg.xml");
		SchemaExport schemaExport = new SchemaExport(cfg);
		schemaExport.drop(true, true);
		schemaExport.setOutputFile("testDB.sql");
		schemaExport.create(true, true);
		
	}

	public static void main(String[] args) {
		createDatabase();

	}

}
