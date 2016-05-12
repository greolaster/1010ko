/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t2group.frontend.nilai.controller;

import com.t2group.frontend.nilai.model.Jurusan;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author TomiTeruz
 */
@ManagedBean(name="jurusan")
public class JurusanController {
    private URL obj;
    Jurusan jsn;
    
    public List<Jurusan> getJurusanByFakultas() throws Exception{
        List<Jurusan> jurusanList = new ArrayList<>();
        String url = "http://localhost:9090/Service/jurusan/";
        String pathParam = jsn.getKode_fakultas();
        obj = new URL(url+pathParam);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.addRequestProperty("Authorization", "Basic YWRtaW46YWRtaW4=");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputline;
        StringBuffer response = new StringBuffer();
        while((inputline=in.readLine()) != null){
            response.append(inputline);
        }
        in.close();
        JSONObject rs;
        JSONObject jObject = new JSONObject(response.toString());
        JSONArray jArray = (JSONArray) jObject.getJSONArray("result");
        for (int i = 0; i < jArray.length(); i++) {
            JSONObject jObjectA = (JSONObject) jArray.get(i);
            rs = (JSONObject) jObjectA.get("map");
            jsn.setNama_jurusan(rs.getString("nama_jurusan"));
            jurusanList.add(jsn);
        }
        return jurusanList;
    }
    
}
