/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t2group.tampilan.model;

/**
 *
 * @author TomiTeruz
 */
public class Penilaian {
    private int id_nilai;
    private String nrp,nama,kode_matkul, matkul,kelas,semester,grade;
    private float sks,nilai;

    public Penilaian() {
    }

    public Penilaian(int id_nilai, String nrp, String nama,String kode_matkul, String matkul, String kelas, String semester, String grade, float sks, float nilai) {
        this.id_nilai = id_nilai;
        this.nrp = nrp;
        this.nama = nama;
        this.kode_matkul = kode_matkul;
        this.matkul = matkul;
        this.kelas = kelas;
        this.semester = semester;
        this.grade = grade;
        this.sks = sks;
        this.nilai = nilai;
    }

    public int getId_nilai() {
        return id_nilai;
    }

    public void setId_nilai(int id_nilai) {
        this.id_nilai = id_nilai;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

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

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public float getSks() {
        return sks;
    }

    public void setSks(float sks) {
        this.sks = sks;
    }

    public float getNilai() {
        return nilai;
    }

    public void setNilai(float nilai) {
        this.nilai = nilai;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    
    
}
