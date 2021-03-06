package rest.mybatis.model.meettingroom;

import java.util.List;

public class MrMeettingEmployee {
	private List<MrSpOrder> mrSporderList;
	private List<MrUserT> mrUserTList;
	
	public List<MrSpOrder> getMrSporderList() {
		return mrSporderList;
	}

	public void setMrSporderList(List<MrSpOrder> mrSporderList) {
		this.mrSporderList = mrSporderList;
	}

	public List<MrUserT> getMrUserTList() {
		return mrUserTList;
	}

	public void setMrUserTList(List<MrUserT> mrUserTList) {
		this.mrUserTList = mrUserTList;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEETTING_EMPLOYEE.ID
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEETTING_EMPLOYEE.EMPLOYEE_ID
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    private Integer employeeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEETTING_EMPLOYEE.MEETTING_ID
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    private Integer meettingId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEETTING_EMPLOYEE.ID
     *
     * @return the value of MEETTING_EMPLOYEE.ID
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEETTING_EMPLOYEE.ID
     *
     * @param id the value for MEETTING_EMPLOYEE.ID
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEETTING_EMPLOYEE.EMPLOYEE_ID
     *
     * @return the value of MEETTING_EMPLOYEE.EMPLOYEE_ID
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEETTING_EMPLOYEE.EMPLOYEE_ID
     *
     * @param employeeId the value for MEETTING_EMPLOYEE.EMPLOYEE_ID
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEETTING_EMPLOYEE.MEETTING_ID
     *
     * @return the value of MEETTING_EMPLOYEE.MEETTING_ID
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public Integer getMeettingId() {
        return meettingId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEETTING_EMPLOYEE.MEETTING_ID
     *
     * @param meettingId the value for MEETTING_EMPLOYEE.MEETTING_ID
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public void setMeettingId(Integer meettingId) {
        this.meettingId = meettingId;
    }
}