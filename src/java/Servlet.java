


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {
    

  public String message = "<a href=\"#\" onclick=\"history.go(-1)\">Go Back</a>";
  public String message1 = "or click \"back\" on your browser navigation.";
  public int height, width;
  public String frameType;
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Calculator calc = null;
        try {
            int height = Integer.parseInt(request.getParameter("height"));
            int width = Integer.parseInt(request.getParameter("width"));
            this.height = height;
            this.width = width;
            String frametype_str = request.getParameter("frametype");
            this.frameType = frametype_str;
            Calculator.FRAMETYPE frametype;
            switch (frametype_str) {
                case "wood":
                    frametype = Calculator.FRAMETYPE.WOOD;
                    break;
                case "pvc":
                    frametype = Calculator.FRAMETYPE.PVC;
                    break;
                case "aluminium":
                    frametype = Calculator.FRAMETYPE.ALUMINIUM;
                    break;
                default:
                    frametype = Calculator.FRAMETYPE.WOOD;
                    break;
            }
            calc = new Calculator(height, width, frametype);
        } catch (Exception e) {
            response.sendRedirect("404.html");
            return;
        }

        ServletOutputStream out = response.getOutputStream();

        String str = "<!DOCTYPE html>"
                + "<html>"
                + "    <head>"
                + "        <meta charset=\"ISO-8859-1\">"
                + "        <title>Your order</title>"
                + "        <link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheet.css\">"
                + "    </head>"
                + "    <body>"
                + "    <div class=\"container\">"
                + "        <h4>"+message+"</h4>"
                + "        <p>"+"Height: "+this.height+"</p>"
                + "        <p>"+"Width: "+this.width+"</p>"
                + "        <p>"+"Frame Type: "+this.frameType+"</p>"
                + "        <h4>" + message1 + "</h4>"

                + "        <hr>"
                + "        <h2>"+"Here you can see the price for your order:"+"</h2>"
                + "        <hr>"
                + "            <table>"
                + "                <tr>"
                + "                    <td>Glass price: </td>"
                + "                    <td></td>"
                + "                    <td>kr. " + String.format("%.2f", calc.getGlassPrice()) + "</td>"
                + "                </tr>"
                + "                <tr>"
                + "                    <td>Frame price: </td>"
                + "                    <td>+</td>"
                + "                    <td>kr. " + String.format("%.2f", calc.getFramePrice()) + "</td>"
                + "                </tr>"
                + "                <tr>"
                + "                    <td>Total price: </td>"
                + "                    <td>=</td>"
                + "                    <td>kr. " + String.format("%.2f", calc.getTotalPrice()) + "</td>"
                + "                </tr>"
                + "            </table>"
                + "        </p>"
                + "        </div>"
                + "    </body>"
                + "</html>";

        out.println(str);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This is Servlet for ordering a windows with different type of frames from clients like glaziers.";
    }// </editor-fold>

}
