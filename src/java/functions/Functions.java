package functions;

public class Functions {
    public String[] splitData(String data){
        String[] data2 = data.split("&");
        String[] data3 = null;
        for (String data21 : data2) {
            data3 = data21.split("=");
        }
        return data3;
    }
}
