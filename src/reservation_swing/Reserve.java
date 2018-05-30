/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation_swing;


public class Reserve {
    
    private String ID;
    private String date;
    private String day;
    private String visitor;
    private String room_num;
    private String amenities;
    private String xtra_amenities;
    private String total;
    
    
    public Reserve(String id,String d, String da, String v, String rn, String am, String xtra_am, String to){
        this.ID = id;
        this.date = d;
        this.day = da;
        this.visitor = v;
        this.room_num = rn;
        this.amenities = am;
        this.xtra_amenities = xtra_am;
        this.total = to;
        
    }
    
    public String getId(){
        return ID;
    }
    
    public String getDate(){
        return date;
    }
    public String getDay(){
        return day;
    }
    public String getVisitor(){
        return visitor;
    }
    public String getRoomNumber(){
        return room_num;
    }
   
    public String getAmenities(){
        return amenities;
    }
    
    public String getXtraAmenities(){
        return xtra_amenities;
    }
    public String getTotal(){
        return total;
    }
}
