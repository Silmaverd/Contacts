package przemyslaw.sen.contactAPI.contactAPI.source;

import przemyslaw.sen.contactAPI.contactAPI.source.xml.XMLDataSource;

public class DataSourceFactory {

    // very simplictic due to lack of time
    public static DataSource determineDataSource(String path){
        if (path.substring(path.lastIndexOf("."), path.length()).equals(".xml"))
            return new XMLDataSource();
        else return null;
    }
}
