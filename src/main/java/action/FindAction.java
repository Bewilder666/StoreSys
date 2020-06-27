package action;
import model.item;

import java.util.ArrayList;
public class FindAction
{
    String iitem;
    private ArrayList<item> items = new ArrayList<item>();
    public String getIitem() {
        return iitem;
    }
    public void setIitem(String iitem) {
        this.iitem = iitem;
    }
    public String execute()
    {
        items = (ArrayList<item>) LoginAction.session.get("items");
        for (int i=items.size()-1;i>=0;i--)
        {
            if (!items.get(i).getItem().contains(iitem))
            {
                items.remove(i);
            }
        }
        LoginAction.session.replace("items",items);
        return "success";
    }

}
