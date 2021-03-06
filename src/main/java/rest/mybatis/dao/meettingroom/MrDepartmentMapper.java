package rest.mybatis.dao.meettingroom;

import java.util.List;

import rest.mybatis.model.meettingroom.MrDepartment;
import rest.mybatis.model.meettingroom.MrDepartmentWithBLOBs;

public interface MrDepartmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Department
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    int deleteByPrimaryKey(Integer departmentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Department
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    int insert(MrDepartmentWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Department
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    int insertSelective(MrDepartmentWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Department
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    MrDepartmentWithBLOBs selectByPrimaryKey(Integer departmentId);
    List<MrDepartmentWithBLOBs> selectAllMrDepartment();
    List<MrDepartmentWithBLOBs> selectMrDepartmentByName(String deparmentName);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Department
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    int updateByPrimaryKeySelective(MrDepartmentWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Department
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    int updateByPrimaryKeyWithBLOBs(MrDepartmentWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Department
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    int updateByPrimaryKey(MrDepartment record);
}