package com.example.teamprojectmusicandpainting.domain;

public class User extends Entity<Long>{
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String userMusicPlaylist;

    public User() {
    }

    public User(String first_name, String last_name, String email, String password, String userMusicPlaylist) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.userMusicPlaylist = userMusicPlaylist;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserMusicPlaylist() {
        return userMusicPlaylist;
    }

    public void setMyPlaylist(String myPlaylist) {
        this.userMusicPlaylist = myPlaylist;
    }

    @Override
    public String toString() {
        return "User{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userMusicPlaylist=" + userMusicPlaylist +
                '}';
    }
}
