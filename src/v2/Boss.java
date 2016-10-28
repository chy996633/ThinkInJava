package v2;

/**
 * Created by Andrew on 2016/10/28.
 */
public class Boss {

    public int status = 0;

    public void enterOffice(){
        status = 1;
    }


    public void leaveOffice(){
        status = -1;
    }



}
