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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author TomiTeruz
 */
@Path("/fakultas")
public class FakultasService  extends MasterConnection{
    @GET
    @Path("/allFakultas")
    @Produces(MediaType.APPLICATION_JSON)
    public Map getAllFakultas() {
        Map<String, Object> rs = new HashMap<String, Object>();
        try {
            createConnection();
            List fakultas = (List) jt.queryList("select * from fakultas", new MyMap());
            closeConnection();
            if (fakultas != null) {
                rs.put("result", fakultas);
            }
        } catch (Exception e) {
            rs.put("Pesan", "Gagal karena : " + e.getMessage());
        }
        return rs;
    }
}
