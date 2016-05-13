/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t2group.frontend.nilai.controller;

import com.t2group.frontend.nilai.model.Komplain;
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
@ManagedBean(name="komg")
public class KomController {
    public URL obj;
    public List<Komplain> getAllKomplain() throws Exception{
        List<Komplain> komList = new ArrayList<>();
        String url ="http://localhost:9090/Service/komplain/all";
        obj = new URL(url);
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
        JSONArray jArray =  (JSONArray) jObject.get("result");
        for(int i = 0; i< jArray.length(); i++){
            JSONObject jONObjectA = (JSONObject) jArray.get(i);
            rs = (JSONObject) jONObjectA.get("map");
            Komplain kom = new Komplain();
            kom.setId_kom(rs.getInt("id_kom"));
            kom.setNrp(rs.getString("nrp"));
            kom.setGrade_now(rs.getString("grade_now"));
            kom.setKelas(rs.getString("kelas"));
            kom.setKet(rs.getString("ket"));
            komList.add(kom);
        }
        return komList;
    }
    
}
