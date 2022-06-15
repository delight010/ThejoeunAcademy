package com.aoslec.atsumori.Bean;


public class MoriList  {
    private int code;
    private String name;
    private String gender;
    private String chara;
    private String birth;

    public MoriList(int code, String name, String gender, String chara, String birth) {
        this.code = code;
        this.name = name;
        this.gender = gender;
        this.chara = chara;
        this.birth = birth;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getChara() {
        return chara;
    }

    public void setChara(String chara) {
        this.chara = chara;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
