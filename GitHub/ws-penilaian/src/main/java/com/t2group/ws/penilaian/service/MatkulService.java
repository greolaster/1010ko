/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t2group.ws.penilaian.service;

import com.t2group.ws.penilaian.common.MasterConnection;
import com.t2group.ws.penilaian.common.MyMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/matkul")
public class MatkulService extends MasterConnection {

    @GET
    @Path("/{kode_matkul}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map getMatkuls(@PathParam("kode_matkul") String kode_matkul) {
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put("Pesan", "Berhasil");
        System.out.println("kode matkul " + kode_matkul);
        try {
            createConnection();
            MyMap matkul = (MyMap) jt.queryObject("select * from tb_matkul where kode_matkul = ?",
                    new Object[]{kode_matkul}, new MyMap());
            closeConnection();
            if (matkul != null) {
                rs.put("result", matkul);
            }
        } catch (Exception e) {
            rs.put("Pesan", "Gagal karena : " + e.getMessage());
        }
        return rs;
    }

    @GET
    @Path("/jurusan/{kode_jurusan}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map getMatkulByjurusan(@PathParam("kode_jurusan") String kode_jurusan) {
        Map<String, Object> rs = new HashMap<String, Object>();
        System.out.println("Jurusan " + kode_jurusan);
        try {
            createConnection();
            List matkul = (List) jt.queryList("select matkul from tb_matkul where kode_jurusan = ?", new Object[]{kode_jurusan}, new MyMap());
            closeConnection();
            if (matkul != null) {
                rs.put("result :", matkul);
            }
        } catch (Exception e) {
            rs.put("Pesan", "Gagal karena : " + e.getMessage());
        }
        return rs;
    }
    
    @GET
    @Path("/allMatkul")
    @Produces(MediaType.APPLICATION_JSON)
    public Map getAllMatkul() {
        Map<String, Object> rs = new HashMap<String, Object>();
        try {
            createConnection();
            List matkul = (List) jt.queryList("select * from tb_matkul", new MyMap());
            closeConnection();
            if (matkul != null) {
                rs.put("result :", matkul);
            }
        } catch (Exception e) {
            rs.put("Pesan", "Gagal karena : " + e.getMessage());
        }
        return rs;
    }

    @GET
    @Path("/matkul={kode_matkul}/jurusan={kode_jurusan}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map getMatkulByJurusanandKode(
            @PathParam("kode_matkul") String kode_matkul,
            @PathParam("kode_jurusan") String kode_jurusan) {
        Map<String, Object> rs = new HashMap<String, Object>();
        System.out.println("Matkul " + kode_matkul);
        System.out.println("Jurusan " + kode_jurusan);
        try {
            createConnection();
            List matkul = (List) jt.queryList("select * from tb_matkul where kode_matkul = ? and kode_jurusan=?",
                    new Object[]{kode_matkul,kode_jurusan}, new MyMap());
            closeConnection();
            if (matkul != null) {
                rs.put("result :", matkul);
            }
        } catch (Exception e) {
            rs.put("Pesan", "Gagal karena : " + e.getMessage());
        }
        return rs;
    }

}
