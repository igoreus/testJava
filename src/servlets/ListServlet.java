package servlets;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PaymentDao;
import model.Amount;
import model.Category;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    static final Logger logger = Logger.getLogger(ListServlet.class);

    public ListServlet() {
        super();
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PropertyConfigurator.configure(this.getClass().getClassLoader().getResourceAsStream("log4j.properties"));
        logger.debug("Sample debug message");
        logger.fatal("Sample fatal message");

        requestLog(request);


        List <Category> categoryList = PaymentDao.getInstance().getCategoryList();
        List <Amount> amountList = PaymentDao.getInstance().getAmountList();

        request.setAttribute("categoryList", categoryList);
        request.setAttribute("amountList", amountList);
        request.getRequestDispatcher("/result_list.jsp").forward(request, response);
    }

    private void requestLog(HttpServletRequest request) {
        logger.info(request.getPathInfo());
        logger.info(request.getQueryString());
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List <Amount> amountList = PaymentDao.getInstance().getAmountList();

        String nameParam = request.getParameter("title");
        String categoryParam = request.getParameter("category");
        int amountParam = 0;

        try {
            amountParam = Integer.parseInt(request.getParameter("amount"));
        } catch(NumberFormatException nFE) {}

        Category category = PaymentDao.getInstance().getCategoryByName(categoryParam);

        amountList.add(new Amount(nameParam, amountParam, category));
        response.sendRedirect("list");
    }


}
