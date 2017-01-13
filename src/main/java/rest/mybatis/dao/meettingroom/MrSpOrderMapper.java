package rest.mybatis.dao.meettingroom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import rest.mybatis.model.meettingroom.MrSpOrder;

public interface MrSpOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SP_ORDER
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SP_ORDER
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    int insert(MrSpOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SP_ORDER
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    int insertSelective(MrSpOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SP_ORDER
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    MrSpOrder selectByPrimaryKey(Integer id);
    List<MrSpOrder> selectByMeettingRoomId(@Param(value="meettingRoomId") Integer meettingRoomId,@Param(value="startdate")String startdate);
    List<MrSpOrder> selectAllMrSpOrder();
    MrSpOrder selectLastMrSpOrder();
    List<MrSpOrder> selectByStartDate(String startDate);
    MrSpOrder selectBefor(@Param(value="time")String  time,@Param(value="MeId") Integer MeId);
    MrSpOrder selectNext(@Param(value="time")String  time,@Param(value="MeId") Integer MeId);
    Integer selectSporderCounts(Integer userId);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SP_ORDER
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    int updateByPrimaryKeySelective(MrSpOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SP_ORDER
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    int updateByPrimaryKeyWithBLOBs(MrSpOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SP_ORDER
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    int updateByPrimaryKey(MrSpOrder record);
}