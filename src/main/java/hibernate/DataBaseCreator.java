package hibernate;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class DataBaseCreator {

	public static void createDatabase() {

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
