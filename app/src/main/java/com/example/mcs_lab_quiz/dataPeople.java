package com.example.mcs_lab_quiz;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class dataPeople implements Parcelable {

    private String register_username, register_email, register_phone, register_password;
    private int UserID;

    public dataPeople(String register_username, String register_email, String register_phone, String register_password, int userID) {
        this.register_username = register_username;
        this.register_email = register_email;
        this.register_phone = register_phone;
        this.register_password = register_password;
        this.UserID = userID;
    }

    public String getRegister_username() {
        return register_username;
    }

    public void setRegister_username(String register_username) {
        this.register_username = register_username;
    }

    public String getRegister_email() {
        return register_email;
    }

    public void setRegister_email(String register_email) {
        this.register_email = register_email;
    }

    public String getRegister_phone() {
        return register_phone;
    }

    public void setRegister_phone(String register_phone) {
        this.register_phone = register_phone;
    }

    public String getRegister_password() {
        return register_password;
    }

    public void setRegister_password(String register_password) {
        this.register_password = register_password;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }



    protected dataPeople(Parcel in) {
        register_username = in.readString();
        register_email = in.readString();
        register_phone = in.readString();
        register_password = in.readString();
        UserID = in.readInt();
    }

    public static final Creator<dataPeople> CREATOR = new Creator<dataPeople>() {
        @Override
        public dataPeople createFromParcel(Parcel in) {
            return new dataPeople(in);
        }

        @Override
        public dataPeople[] newArray(int size) {
            return new dataPeople[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(register_username);
        dest.writeString(register_email);
        dest.writeString(register_phone);
        dest.writeString(register_password);
        dest.writeInt(UserID);
    }
}
