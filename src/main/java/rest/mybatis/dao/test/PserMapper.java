package rest.mybatis.dao.test;

import rest.mybatis.model.test.Pser;
import rest.mybatis.model.test.PserWithBLOBs;

public interface PserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PSER
     *
     * @mbggenerated Mon Nov 28 14:58:32 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PSER
     *
     * @mbggenerated Mon Nov 28 14:58:32 CST 2016
     */
    int insert(PserWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PSER
     *
     * @mbggenerated Mon Nov 28 14:58:32 CST 2016
     */
    int insertSelective(PserWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PSER
     *
     * @mbggenerated Mon Nov 28 14:58:32 CST 2016
     */
    PserWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PSER
     *
     * @mbggenerated Mon Nov 28 14:58:32 CST 2016
     */
    int updateByPrimaryKeySelective(PserWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PSER
     *
     * @mbggenerated Mon Nov 28 14:58:32 CST 2016
     */
    int updateByPrimaryKeyWithBLOBs(PserWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PSER
     *
     * @mbggenerated Mon Nov 28 14:58:32 CST 2016
     */
    int updateByPrimaryKey(Pser record);
}