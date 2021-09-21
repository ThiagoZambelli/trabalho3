package com.trabalho.trabalho_3.ui.Models;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Todo implements Parcelable {
    private int id;
    private int user_id;
    private String title;
    private Boolean completed;

    public Todo(int id, int user_id, String title, Boolean completed) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.completed = completed;
    }
    public Todo(JSONObject json) {
        super();
        try {
            this.id = json.getInt("id");
            this.user_id = json.getInt("userId");
            this.title = json.getString("title");
            this.completed =json.getBoolean("completed");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected Todo(Parcel in) {
        id = in.readInt();
        user_id = in.readInt();
        title = in.readString();
        byte tmpCompleted = in.readByte();
        completed = tmpCompleted == 0 ? null : tmpCompleted == 1;
    }

    public static final Creator<Todo> CREATOR = new Creator<Todo>() {
        @Override
        public Todo createFromParcel(Parcel in) {
            return new Todo(in);
        }

        @Override
        public Todo[] newArray(int size) {
            return new Todo[size];
        }
    };

    @Override
    public String toString(){
        return "id: "+id+"\n"+
                "Id usuário: "+user_id+"\n"+
                "Título: "+title+"\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeInt(this.user_id);
        parcel.writeString(this.title);
        parcel.writeBoolean(this.completed);
    }
}
