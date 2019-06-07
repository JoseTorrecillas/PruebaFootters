package com.josea.pruebafootters.UI.Entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class BaseResponse<T> implements Parcelable {
    private List<T> data;

    public BaseResponse() {
    }

    protected BaseResponse(Parcel in) {
    }

    public static final Creator<BaseResponse> CREATOR = new Creator<BaseResponse>() {
        @Override
        public BaseResponse createFromParcel(Parcel in) {
            return new BaseResponse(in);
        }

        @Override
        public BaseResponse[] newArray(int size) {
            return new BaseResponse[size];
        }
    };

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
