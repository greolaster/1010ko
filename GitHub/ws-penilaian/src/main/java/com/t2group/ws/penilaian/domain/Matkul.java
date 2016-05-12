/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t2group.ws.penilaian.domain;

/**
 *
 * @author tomit
 */
public class Matkul {
    private String kode_matkul,matkul,kode_jurusan;
    private float sks;

    public String getKode_matkul() {
        return kode_matkul;
    }

    public void setKode_matkul(String kode_matkul) {
        this.kode_matkul = kode_matkul;
    }

    public String getMatkul() {
        return matkul;
    }

    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }

    public String getKode_jurusan() {
        return kode_jurusan;
    }

    public void setKode_jurusan(String kode_jurusan) {
        this.kode_jurusan = kode_jurusan;
    }

    public float getSks() {
        return sks;
    }

    public void setSks(float sks) {
        this.sks = sks;
    }
    
//    @Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "Matkul : "+kode_matkul+" - "+matkul+" - "+sks+" - "+kode_jurusan;
//	}
    
}
