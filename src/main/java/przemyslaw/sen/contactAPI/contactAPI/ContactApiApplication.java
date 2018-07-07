package przemyslaw.sen.contactAPI.contactAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import przemyslaw.sen.contactAPI.contactAPI.source.DataSource;
import przemyslaw.sen.contactAPI.contactAPI.source.DataSourceFactory;

@SpringBootApplication
@Component
public class ContactApiApplication{

    //TODO: should check if argument is given
	public static void main(String[] args) {

	    SpringApplication.run(ContactApiApplication.class, args);

	    DataSource dataSource = DataSourceFactory.determineDataSource(args[0]);

	    dataSource.read(args[0]);

	}
}
