package de.hsw.webapp;

import java.time.LocalDate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CounterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) {

        String firstVisit = LocalDate.now().toString();

        boolean hasCookie = false;

        if (request.getCookies() != null) {
            for (int i = 0; i < request.getCookies().length; i++) {
                String name = request.getCookies()[i].getName();

                if (name.equals("firstVisit")) {
                    hasCookie = true;
                    firstVisit = request.getCookies()[i].getValue();
                }
            }
        }

        if (!hasCookie) {
            Cookie userCookie = new Cookie("firstVisit", firstVisit);
            userCookie.setMaxAge(86400 * 365);
            response.addCookie(userCookie);
        }

        if (request.getSession().getAttribute("count") == null) {
            request.getSession().setAttribute("count", 1);
        } else {
            int count = (int) request.getSession().getAttribute("count");
            request.getSession().setAttribute("count", count + 1);
        }

        try {
            getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
