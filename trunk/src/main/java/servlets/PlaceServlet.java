package servlets;

import DAO.PlaceDAO;
import enums.ActionName;
import model.Place;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Mary Anne
 * Date: 6/20/11
 * Time: 5:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlaceServlet extends HttpServlet {



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        switch (ActionName.valueOf(request.getParameter("action"))) {

            case CREATE_PLACE:
                response.sendRedirect("index.jsp");
                break;
            case MODIFY_PLACE:
                response.sendRedirect("index.jsp");
                break;
            case UPDATE_LOCATION:
                 break;
            case PLACE_MARKERS:
                sendJson(request,response);
                break;

        }


    }

    public String toJSONString(List<Place> places) {
         JSONObject jsonPlaces = new JSONObject();

         for (int i=0;i<places.size();i++){
            JSONObject json = new JSONObject();
            Place place = places.get(i);
            json.put("name",place.getName());
            json.put("address",place.getAddress());
            json.put("latitude",place.getLocation().getLatitude());
            jsonPlaces.put(String.valueOf(i),json);
        }

       return jsonPlaces.toString();
   }

     public void sendJson(HttpServletRequest request, HttpServletResponse response) {

       List<Place> places = PlaceDAO.retrievePlaceList();

       String json = toJSONString(places);


//       response.setContentType("text/json");
//       PrintWriter writer = null;
//       try
//
//       {
//           writer = resp.getWritePr();
//           writer.write(json);
//       } catch (
//               IOException e
//               )
//
//       {
//           e.printStackTrace();
//       } finally
//
//       {
//           writer.flush();
//           writer.close();
//       }
     }

    public static void main(String[] args) {
        PlaceServlet p = new PlaceServlet();
        p.sendJson(null,null);
    }

}
