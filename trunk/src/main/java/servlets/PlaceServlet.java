package servlets;

import DAO.PlaceDAO;
import enums.ActionName;
import model.Place;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketTimeoutException;
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
         JSONArray jsonPlaces = new JSONArray();
         for(Place place: places){
            jsonPlaces.put(place.getName());
            jsonPlaces.put(place.getAddress());
            jsonPlaces.put(place.getLocation().getLatitude());
            jsonPlaces.put(place.getLocation().getLongitude());
        }
       return jsonPlaces.toString();
   }

     public void sendJson(HttpServletRequest request, HttpServletResponse response) {

       List<Place> places = PlaceDAO.retrievePlaceList();

       String json = toJSONString(places);

       response.setContentType("text/json");
       PrintWriter writer = null;
       try
       {
           writer = response.getWriter();
           writer.write(json);
       } catch (
               IOException e
               )
       {
           e.printStackTrace();
       } finally{
           writer.flush();
           writer.close();
       }
     }



}
