/**
 * Created by Administrator on 9/6/2016.
 */
public class TranslateData {
    public String translateData(byte[] data){
        try{
            return new String(data,"utf-8");
        }
        catch (Exception e){
            return null;
        }
    }
}
