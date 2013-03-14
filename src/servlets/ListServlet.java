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

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

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

        List <Category> categoryList = PaymentDao.getInstance().getCategoryList();
        List <Amount> amountList = PaymentDao.getInstance().getAmountList();

        request.setAttribute("categoryList", categoryList);
        request.setAttribute("amountList", amountList);
        request.getRequestDispatcher("list.jsp").forward(request, response);
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
