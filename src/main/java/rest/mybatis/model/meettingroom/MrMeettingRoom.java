package rest.mybatis.model.meettingroom;

import java.util.Date;

public class MrMeettingRoom {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEETTING_ROOM.ID
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEETTING_ROOM.MEETING_ROOM_NAME
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    private String meetingRoomName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEETTING_ROOM.ROOM_ACCOUNT
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    private String roomAccount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEETTING_ROOM.PASSWORD
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEETTING_ROOM.CHANGE_TIME
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    private Date changeTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEETTING_ROOM.WHO
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    private String who;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEETTING_ROOM.ID
     *
     * @return the value of MEETTING_ROOM.ID
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEETTING_ROOM.ID
     *
     * @param id the value for MEETTING_ROOM.ID
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEETTING_ROOM.MEETING_ROOM_NAME
     *
     * @return the value of MEETTING_ROOM.MEETING_ROOM_NAME
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public String getMeetingRoomName() {
        return meetingRoomName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEETTING_ROOM.MEETING_ROOM_NAME
     *
     * @param meetingRoomName the value for MEETTING_ROOM.MEETING_ROOM_NAME
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public void setMeetingRoomName(String meetingRoomName) {
        this.meetingRoomName = meetingRoomName == null ? null : meetingRoomName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEETTING_ROOM.ROOM_ACCOUNT
     *
     * @return the value of MEETTING_ROOM.ROOM_ACCOUNT
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public String getRoomAccount() {
        return roomAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEETTING_ROOM.ROOM_ACCOUNT
     *
     * @param roomAccount the value for MEETTING_ROOM.ROOM_ACCOUNT
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public void setRoomAccount(String roomAccount) {
        this.roomAccount = roomAccount == null ? null : roomAccount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEETTING_ROOM.PASSWORD
     *
     * @return the value of MEETTING_ROOM.PASSWORD
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEETTING_ROOM.PASSWORD
     *
     * @param password the value for MEETTING_ROOM.PASSWORD
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEETTING_ROOM.CHANGE_TIME
     *
     * @return the value of MEETTING_ROOM.CHANGE_TIME
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public Date getChangeTime() {
        return changeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEETTING_ROOM.CHANGE_TIME
     *
     * @param changeTime the value for MEETTING_ROOM.CHANGE_TIME
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEETTING_ROOM.WHO
     *
     * @return the value of MEETTING_ROOM.WHO
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public String getWho() {
        return who;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEETTING_ROOM.WHO
     *
     * @param who the value for MEETTING_ROOM.WHO
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public void setWho(String who) {
        this.who = who == null ? null : who.trim();
    }
}