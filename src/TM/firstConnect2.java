package TM;

import Model.ResponeModel2;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class firstConnect2 {
    public static void main(String[] args) throws IOException {
        connectURI2 koneksiSaya = new connectURI2();
        URL myAddres = koneksiSaya.builURL("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
        String response = koneksiSaya.GetResponseFromHttpurl(myAddres);
        System.out.println(response);

        assert response != null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList<ResponeModel2> ResponseModel = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < responseJSON.length(); i++) {
            ResponeModel2 resModel = new ResponeModel2();
            JSONObject myJSONObject = responseJSON.getJSONObject(i);
            String harga = myJSONObject.getString("i_sell");
            resModel.setI_sell(harga);
            ResponseModel.add(resModel);

            int priceInt = Integer.parseInt(harga);
            if (priceInt <= 2000) {
                count++;
            }
            System.out.println("obat harga 2000 + = count");
            for (int index = 0; index < ResponseModel.size(); index++) {
                int hargaInt = Integer.parseInt(ResponseModel.get(index).getI_sell());
                if (hargaInt <= 2000) {
                    System.out.println("harga :" + harga);

                }
            }

            System.out.println("obat diharga dengan 2000 = " + count);
        }


    }
}
