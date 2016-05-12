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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author TomiTeruz
 */
@Path("/jurusan")
public class JurusanService extends MasterConnection{
    @GET
    @Path("/{kode_fakultas}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map getJurusanByFakultas(@PathParam("kode_fakultas") String kode_fakultas) {
        Map<String, Object> rs = new HashMap<String, Object>();
        System.out.println("kode fakultas " + kode_fakultas);
        try {
            createConnection();
            List jurusan = (List) jt.queryList("select kode_jurusan,nama_jurusan from jurusan where kode_fakultas = ?", new Object[]{kode_fakultas}, new MyMap());
            closeConnection();
            if (jurusan != null) {
                rs.put("result", jurusan);
            }
        } catch (Exception e) {
            rs.put("Pesan", "Gagal karena : " + e.getMessage());
        }
        return rs;
    }
}
