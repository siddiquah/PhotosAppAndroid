package tech.hamid.android_internship_assessment;

public class Details {

    private String name;
    private String description;
    private String main_img;
    private String profile_img;
    private String userBio;
    private String userLocation;

    public Details(String name, String description, String main_img, String profile_img, String bio, String location) {
        this.name = name;
        this.description = description;
        this.main_img = main_img;
        this.profile_img = profile_img;
        this.userBio = bio;
        this.userLocation = location;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getMain_img() {
        return main_img;
    }

    public String getProfile_img() {
        return profile_img;
    }

    public String getUserBio() {
        return userBio;
    }

    public String getUserLocation() {
        return userLocation;
    }
}
