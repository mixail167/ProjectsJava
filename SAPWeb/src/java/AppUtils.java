
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.servlet.http.HttpSession;

public class AppUtils {

    private static int REDIRECT_ID = 0;
    private static final Map<Integer, String> id_uri_map = new HashMap<Integer, String>();
    private static final Map<String, Integer> uri_id_map = new HashMap<String, Integer>();
    private static MyDestinationDataProvider provider = new MyDestinationDataProvider();
    
    public static void storeDestination(HttpSession session, JCoDestination destination) {
        session.setAttribute("destination", destination);
        session.setMaxInactiveInterval(20);
    }

    public static JCoDestination getDestination(HttpSession session) {
        return (JCoDestination) session.getAttribute("destination");
    }

    public static int storeRedirectAfterLoginUrl(HttpSession session, String requestUri) {
        Integer id = uri_id_map.get(requestUri);
        if (id == null) {
            id = REDIRECT_ID++;
            uri_id_map.put(requestUri, id);
            id_uri_map.put(id, requestUri);
            return id;
        }
        return id;
    }

    public static String getRedirectAfterLoginUrl(HttpSession session, int redirectId) {
        String url = id_uri_map.get(redirectId);
        if (url != null) {
            return url;
        }
        return null;
    }

    public static JCoDestination getConnection(UserAccount user) {
        Properties jcoPropertiesA01 = new Properties();
        jcoPropertiesA01.setProperty(DestinationDataProvider.JCO_ASHOST, "METdb");
        jcoPropertiesA01.setProperty(DestinationDataProvider.JCO_SYSNR, "01");
        jcoPropertiesA01.setProperty(DestinationDataProvider.JCO_CLIENT, "112");
        jcoPropertiesA01.setProperty(DestinationDataProvider.JCO_USER, user.getUserName().toUpperCase());
        jcoPropertiesA01.setProperty(DestinationDataProvider.JCO_PASSWD, user.getPassword());
        jcoPropertiesA01.setProperty(DestinationDataProvider.JCO_LANG, "RU");
//        jcoPropertiesA01.setProperty(DestinationDataProvider.JCO_POOL_CAPACITY, "10" );
//        jcoPropertiesA01.setProperty(DestinationDataProvider.JCO_PEAK_LIMIT, "value" );
        provider.clearDestinations();
        provider.addDestination("A01", jcoPropertiesA01);
        //createDestinationDataFile("A01", jcoPropertiesA01);
        if (Environment.isDestinationDataProviderRegistered()) {
            Environment.unregisterDestinationDataProvider(provider);
        }
        Environment.registerDestinationDataProvider(provider);
        JCoDestination destination;
        try {
            destination = JCoDestinationManager.getDestination("A01");
            destination.ping();
            return destination;
        } catch (JCoException ex) {
            return null;
        }
        finally
        {   
            //Environment.unregisterDestinationDataProvider(provider);
        }
    }

    private static void createDestinationDataFile(String destinationName, Properties connectProperties) {
        // TODO
        File destCfg = new File(destinationName + ".jcoDestination");
        try {
            FileOutputStream fos = new FileOutputStream(destCfg, false);
            connectProperties.store(fos, "");
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException("Unable to create the destination files", e);
        }

    }
}
