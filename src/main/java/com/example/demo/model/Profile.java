package com.example.demo.model;

import com.example.demo.model.auth.AppUser;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String fullName;
    private String email;
    private String phone;
    private String profilepicture;
    private String coverpicture;
    private String lastestPost;
    private Date birthDate;

    @OneToMany(mappedBy = "profile")
    private Set<Interest> interests;

    @OneToMany(mappedBy = "profile")
    private Set<PreviousPost>posts;

    @OneToMany
    private Set<Friend> friends;

    @OneToOne
    AppUser profileOwner;

    public Profile() {
        this.interests = new HashSet<>();
        this.posts = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfilepicture() {
        return profilepicture;
    }

    public void setProfilepicture(String profilepicture) {
        this.profilepicture = profilepicture;
    }

    public String getCoverpicture() {
        return coverpicture;
    }

    public void setCoverpicture(String coverpicture) {
        this.coverpicture = coverpicture;
    }

    public String getLastestPost() {
        return lastestPost;
    }

    public void setLastestPost(String lastestPost) {
        this.lastestPost = lastestPost;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Interest> getInterests() {
        return interests;
    }

    public void setInterests(Set<Interest> interests) {
        this.interests = interests;
    }

    public Set<PreviousPost> getPosts() {
        return posts;
    }

    public void setPosts(Set<PreviousPost> posts) {
        this.posts = posts;
    }

    public Set<Friend> getFriends() {
        return friends;
    }

    public void setFriends(Set<Friend> friends) {
        this.friends = friends;
    }

    public AppUser getProfileOwner() {
        return profileOwner;
    }

    public void setProfileOwner(AppUser profileOwner) {
        this.profileOwner = profileOwner;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void addInterest(Interest interest){
        interests.add(interest);
    }

    public void addPost(PreviousPost previousPost){
        posts.add(previousPost);
    }

    public void addFriend(Friend friend){
        friends.add(friend);
    }
}
