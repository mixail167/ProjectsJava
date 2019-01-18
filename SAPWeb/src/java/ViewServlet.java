
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet implements Filter{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JCoDestination destination = (JCoDestination) request.getSession().getAttribute("destination");
        if (destination == null) {
            request.getRequestDispatcher("/").forward(request, response);
            return;
        }
        try {
            JCoRepository repository = destination.getRepository();
            JCoFunction function1 = repository.getFunction("BAPI_COMPANY_GETLIST");
            JCoFunction function2 = repository.getFunction("BAPI_COMPANY_GETDETAIL");
            function1.execute(destination);
            JCoTable companyTable = function1.getTableParameterList().getTable("COMPANY_LIST");
            int rowCount = companyTable.getNumRows();
            ArrayList<String> list = new ArrayList<>(rowCount);
            for (int i = 0; i < rowCount; i++) {
                companyTable.setRow(i);
                String companyNumber = companyTable.getString("COMPANY");
                String name1 = companyTable.getString("NAME1");
                function2.getImportParameterList().setValue("COMPANYID", companyNumber);
                function2.execute(destination);
                JCoStructure companyDetail = function2.getExportParameterList().getStructure("COMPANY_DETAIL");
                String name2 = companyDetail.getString("NAME2");
                list.add(String.join(" ", name1, name2));
            }
            request.setAttribute("list", list);
        } catch (JCoException ex) {
            Logger.getLogger(ViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("/pages/view.jsp").forward(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
