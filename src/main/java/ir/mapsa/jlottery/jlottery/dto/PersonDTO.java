package ir.mapsa.jlottery.jlottery.dto;


public class PersonDTO {

    private String fullName;
    private Integer score;
    private String username;
    private String password;

    public String getFullName() {
        return this.fullName;
    }

    public Integer getScore() {
        return this.score;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
