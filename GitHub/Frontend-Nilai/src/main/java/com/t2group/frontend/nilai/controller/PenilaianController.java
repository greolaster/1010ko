/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t2group.frontend.nilai.controller;

import com.t2group.frontend.nilai.model.Penilaian;
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
@ManagedBean(name="nilai")
public class PenilaianController {
    private URL obj;
    public List<Penilaian> getAll() throws Exception{
        List<Penilaian> pL = new ArrayList<>();
        String url = "http://localhost:9090/Service/nilai/allNilai";
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
        JSONObject result;
        JSONObject ok = new JSONObject(response.toString());
        JSONArray ok2 =  (JSONArray) ok.get("result :");
        for(int i = 0; i< ok2.length(); i++){
            JSONObject ok3 = (JSONObject) ok2.get(i);
            result = (JSONObject) ok3.get("map");
            Penilaian pn = new Penilaian();
            pn.setId_nilai(result.getInt("id_nilai"));
            pn.setNrp(result.getString("nrp"));
            pn.setNama(result.getString("nama"));
            pn.setKode_matkul(result.getString("kode_matkul"));
            pn.setMatkul(result.getString("matkul"));
            pn.setKelas(result.getString("kelas"));
            pn.setGrade(result.getString("grade"));
            pn.setSemester(result.getString("semester"));
            pn.setSks(result.getLong("sks"));
//            pn.setNilai(result.getLong("nilai"));
           
            pL.add(pn);
        }
        return pL;
    }
    
}
