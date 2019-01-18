/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sapintegration;

import com.sap.conn.jco.ext.DataProviderException;
import com.sap.conn.jco.ext.DestinationDataEventListener;
import com.sap.conn.jco.ext.DestinationDataProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MyDestinationDataProvider implements DestinationDataProvider {

    Map<String, Properties> propertiesForDestinationName = new HashMap<>();

    @Override
    public Properties getDestinationProperties(String destinationName) throws DataProviderException {
        if (propertiesForDestinationName.containsKey(destinationName)) {
            return propertiesForDestinationName.get(destinationName);
        } else {
            throw new RuntimeException("JCo destination not found: " + destinationName);
        }
    }

    public void addDestination(String destinationName, Properties properties) {
        propertiesForDestinationName.put(destinationName, properties);
    }

    @Override
    public boolean supportsEvents() {
        return false;
    }

    @Override
    public void setDestinationDataEventListener(DestinationDataEventListener dl) {
        throw new UnsupportedClassVersionError();
    }
}
