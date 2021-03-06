package rest.mybatis.dao.meettingroom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import rest.mybatis.model.meettingroom.MrMeettingRoom;

public interface MrMeettingRoomMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEETTING_ROOM
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEETTING_ROOM
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    int insert(MrMeettingRoom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEETTING_ROOM
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    int insertSelective(MrMeettingRoom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEETTING_ROOM
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    MrMeettingRoom selectByPrimaryKey(Integer id);
    //分页查询会议室
    List<MrMeettingRoom> selectAllMeettingRoomByPage(@Param("page")Integer page);
    //通过名字查询会议室
    MrMeettingRoom selectMeettingRoomByName(String meetingRoomName);
    //查询会议室总数
    Integer selectMeettingRoomCounts();
    //查询所有会议室
    List<MrMeettingRoom> selectAllMeettingRoom();
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEETTING_ROOM
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    int updateByPrimaryKeySelective(MrMeettingRoom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MEETTING_ROOM
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    int updateByPrimaryKey(MrMeettingRoom record);
}