/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t2group.ws.penilaian.service;

import com.t2group.ws.penilaian.common.MasterConnection;
import com.t2group.ws.penilaian.common.MyMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author TomiTeruz
 */
@Path("/komplain")
public class KomplainService extends MasterConnection {

    @GET
    @Path("/top10")
    @Produces(MediaType.APPLICATION_JSON)
    public Map getLast10Komplain() {
        Map<String, Object> rs = new HashMap<String, Object>();
        try {
            createConnection();
            List komplain = (List) jt.queryList("select * from komplain ", new MyMap());
            closeConnection();
            if (komplain != null) {
                rs.put("result", komplain);
            }
        } catch (Exception e) {
            rs.put("Pesan", "Gagal karena : " + e.getMessage());
        }
        return rs;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Map getAllKomplain() {
        Map<String, Object> rs = new HashMap<String, Object>();
        try {
            createConnection();
            List komplain = (List) jt.queryList("select * from komplain", new MyMap());
            closeConnection();
            if (komplain != null) {
                rs.put("result", komplain);
            }
        } catch (Exception e) {
            rs.put("Pesan", "Gagal karena : " + e.getMessage());
        }
        return rs;
    }
    
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/write")
//    public Object writeKomplain(@Context HttpServletRequest hsr){
//        
//    }
    

}
