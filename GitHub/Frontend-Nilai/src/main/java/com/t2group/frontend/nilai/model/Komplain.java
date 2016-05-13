/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t2group.frontend.nilai.model;

/**
 *
 * @author TomiTeruz
 */
public class Komplain {
    private int id_kom;
    private String nrp,status,ket,grade_now, grade_update,kelas, kode_matkul;

    public Komplain() {
    }

    public int getId_kom() {
        return id_kom;
    }

    public void setId_kom(int id_kom) {
        this.id_kom = id_kom;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getGrade_now() {
        return grade_now;
    }

    public void setGrade_now(String grade_now) {
        this.grade_now = grade_now;
    }

    public String getGrade_update() {
        return grade_update;
    }

    public void setGrade_update(String grade_update) {
        this.grade_update = grade_update;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getKode_matkul() {
        return kode_matkul;
    }

    public void setKode_matkul(String kode_matkul) {
        this.kode_matkul = kode_matkul;
    }
    
}
