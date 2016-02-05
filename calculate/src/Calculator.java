import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

public class Calculator extends HttpServlet {

    Statement st = null;
    ResultSet rs = null;

    public Calculator() {
        super();
    }
        @Override
        protected void doGet(HttpServletRequest request,
                             HttpServletResponse response) throws ServletException, IOException {

        }

        @Override
        protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

            String valueString = request.getParameter("value");
            String resultString = request.getParameter("result");

            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            response.setHeader("Cache-control", "no-cache, no-store");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "-1");

            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type");
            response.setHeader("Access-Control-Max-Age", "86400");

            double result = 0;
            int count = 0;

            ArrayList<Model> list = new ArrayList<>();

            if (!resultString.isEmpty()) {
                result = Double.parseDouble(resultString);
            }
            double oldres = result;
            String sign = null;
            if (!valueString.isEmpty()) {

                double value = Double.parseDouble(valueString);

                Map parameters = request.getParameterMap();

                if (parameters.containsKey("plus")) {
                    result += value;
                    sign="+";
                } else if (parameters.containsKey("minus")) {
                    result -= value;
                    sign="-";
                } else if (parameters.containsKey("divide")) {
                    if(value!=0)
                    result /= value;
                    sign="/";
                } else if (parameters.containsKey("multiply")) {
                    result *= value;
                    sign="*";
                }else if (parameters.containsKey("clear")) {
                    result = 0.0;
                    sign="C";
                }
                DateFormat dformat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
                String cinDate = dformat.format(Calendar.getInstance().getTime());
                try {
                    Class.forName ( "org.postgresql.Driver");
                    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/calculator","postgres","sqwertle");
                    st = con.createStatement();
                    String old = String.valueOf(oldres);
                    String res = null;
                    if(value>=0)
                        res = String.valueOf(value);
                    else
                        res ="(" + String.valueOf(value) + ")";
                    String exp = old.concat(sign.concat(res));
                    if(sign!="C")
                    st.execute("INSERT INTO tb_result(\n" +
                            "            \"Выражение\", \"Результат\", \"Дата\")\n" +
                            "    VALUES ('"+exp+"',"+result+",'"+cinDate+"');");
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    rs = st.executeQuery("SELECT tb_result.\"Выражение\",tb_result.\"Результат\",tb_result.\"Дата\"\n" +
                            "FROM public.tb_result \n" +
                            "OFFSET (\n" +
                            "\tSELECT count(\"ID\")\n" +
                            "\tFROM public.tb_result\n" +
                            ")-5;");
                    Model model = null;
                    JsonObject myObj = new JsonObject();
                    while (rs.next()){
                        model = new Model(rs.getString(1),rs.getDouble(2),rs.getString(3));
                        list.add(model);
                    }
                    Gson gson = new Gson();
                    JsonElement resultObj = gson.toJsonTree(list);
                    if(model.getExp() == null){
                        myObj.addProperty("success", false);
                    }
                    else {
                        myObj.addProperty("success", true);
                    }
                    myObj.addProperty("currvalue",result);
                    myObj.add("model", resultObj);
                    out.println(myObj.toString());
                    out.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
        }
    }