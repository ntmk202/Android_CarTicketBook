package com.ntmk.carticketbook.model;

public class datve {
    int idTuyenxe;
    String inputPlace;
    String inputName;
    String inputNumber;
    String inputEmail;

    public datve(){}

    public datve(int idTuyenxe, String inputPlace, String inputName, String inputNumber, String inputEmail) {
        this.idTuyenxe = idTuyenxe;
        this.inputPlace = inputPlace;
        this.inputName = inputName;
        this.inputNumber = inputNumber;
        this.inputEmail = inputEmail;
    }

    public int getIdTuyenxe() {
        return idTuyenxe;
    }

    public void setIdTuyenxe(int idTuyenxe) {
        this.idTuyenxe = idTuyenxe;
    }

    public String getInputPlace() {
        return inputPlace;
    }

    public void setInputPlace(String inputPlace) {
        this.inputPlace = inputPlace;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    public String getInputEmail() {
        return inputEmail;
    }

    public void setInputEmail(String inputEmail) {
        this.inputEmail = inputEmail;
    }
}



