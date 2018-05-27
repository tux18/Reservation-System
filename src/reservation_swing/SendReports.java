

package reservation_swing;

public class SendReports {
    
    private String id;
    private String date;
    private String total;
    public SendReports(String i, String d, String t){
        this.id = i;
        this.date = d;
        this.total = t;
    }
    
    
    
    public String getId(){
        return id;
    }
    
    public String getDate(){
        return date;
    }
    
    public String getTotal(){
        return total;
    }
    
    
}
