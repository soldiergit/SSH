package com.ssh.models.model;

import javax.persistence.*;

/**
 * @Program: SSH_Gen
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-06-02 15:14
 * @Describe：
 **/
@Entity
@Table(name = "volunteer_sign_up", schema = "young_volunteer", catalog = "")
public class VolunteerSignUpEntity {
    private int signUpId;
    private Integer signIn;
    private Double volunteerScore;
    private String volunteerId;
    private String activityId;

    @Id
    @Column(name = "sign_up_id", nullable = false)
    public int getSignUpId() {
        return signUpId;
    }

    public void setSignUpId(int signUpId) {
        this.signUpId = signUpId;
    }

    @Basic
    @Column(name = "sign_in", nullable = true)
    public Integer getSignIn() {
        return signIn;
    }

    public void setSignIn(Integer signIn) {
        this.signIn = signIn;
    }

    @Basic
    @Column(name = "volunteer_score", nullable = true, precision = 0)
    public Double getVolunteerScore() {
        return volunteerScore;
    }

    public void setVolunteerScore(Double volunteerScore) {
        this.volunteerScore = volunteerScore;
    }

    @Basic
    @Column(name = "volunteer_id", nullable = true, length = 255)
    public String getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(String volunteerId) {
        this.volunteerId = volunteerId;
    }

    @Basic
    @Column(name = "activity_id", nullable = true, length = 255)
    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VolunteerSignUpEntity that = (VolunteerSignUpEntity) o;

        if (signUpId != that.signUpId) return false;
        if (signIn != null ? !signIn.equals(that.signIn) : that.signIn != null) return false;
        if (volunteerScore != null ? !volunteerScore.equals(that.volunteerScore) : that.volunteerScore != null)
            return false;
        if (volunteerId != null ? !volunteerId.equals(that.volunteerId) : that.volunteerId != null) return false;
        if (activityId != null ? !activityId.equals(that.activityId) : that.activityId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = signUpId;
        result = 31 * result + (signIn != null ? signIn.hashCode() : 0);
        result = 31 * result + (volunteerScore != null ? volunteerScore.hashCode() : 0);
        result = 31 * result + (volunteerId != null ? volunteerId.hashCode() : 0);
        result = 31 * result + (activityId != null ? activityId.hashCode() : 0);
        return result;
    }
}
