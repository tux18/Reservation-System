/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation_swing;

/**
 *
 * @author T-Brother
 */
public class Reserve {
    
    private String ID;
    private String date;
    private String day;
    private String visitor;
    private String room_num;
    private String room_size;
    private String amenities;
    private String total;
    
    
    public Reserve(String id,String d, String da, String v, String rn, String rs, String am, String to){
        this.ID = id;
        this.date = d;
        this.day = da;
        this.visitor = v;
        this.room_num = rn;
        this.room_size = rs;
        this.amenities = am;
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
    public String getRoomSize(){
        return room_size;
    }
    public String getAmenities(){
        return amenities;
    }
    public String getTotal(){
        return total;
    }
}
