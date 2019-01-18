/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sapintegration;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mixail167
 */
public class SAPintegration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyDestinationDataProvider provider = new MyDestinationDataProvider();
        Properties jcoPropertiesA01 = new Properties();
        jcoPropertiesA01.setProperty(DestinationDataProvider.JCO_ASHOST, "METdb");
        jcoPropertiesA01.setProperty(DestinationDataProvider.JCO_SYSNR, "01");
        jcoPropertiesA01.setProperty(DestinationDataProvider.JCO_CLIENT, "112");
        jcoPropertiesA01.setProperty(DestinationDataProvider.JCO_USER, "KOVALEV");
        jcoPropertiesA01.setProperty(DestinationDataProvider.JCO_PASSWD, "m19n28j375k");
        jcoPropertiesA01.setProperty(DestinationDataProvider.JCO_LANG, "RU");
//        jcoPropertiesA01.setProperty(DestinationDataProvider.JCO_POOL_CAPACITY, "10" );
//        jcoPropertiesA01.setProperty(DestinationDataProvider.JCO_PEAK_LIMIT, "value" );
        provider.addDestination("A01", jcoPropertiesA01);
        Environment.registerDestinationDataProvider(provider);
        try {
            JCoDestination destination = JCoDestinationManager.getDestination("A01");
            destination.ping();
            JCoRepository repository = destination.getRepository();
            JCoFunction function1 = repository.getFunction("BAPI_COMPANY_GETLIST");
            JCoFunction function2 = repository.getFunction("BAPI_COMPANY_GETDETAIL");
            function1.execute(destination);
            JCoTable companyTable = function1.getTableParameterList().getTable("COMPANY_LIST");
            int rowCount = companyTable.getNumRows();
            for (int i = 0; i < rowCount; i++) {
                companyTable.setRow(i);
                String companyNumber = companyTable.getString("COMPANY");
                String name1 = companyTable.getString("NAME1");
                function2.getImportParameterList().setValue("COMPANYID", companyNumber);
                function2.execute(destination);
                JCoStructure companyDetail = function2.getExportParameterList().getStructure("COMPANY_DETAIL");
                String name2 = companyDetail.getString("NAME2");
                System.out.println(String.join(" ", name1, name2));
            }
        } catch (JCoException ex) {
            Logger.getLogger(SAPintegration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
