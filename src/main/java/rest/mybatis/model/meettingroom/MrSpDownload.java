package rest.mybatis.model.meettingroom;

public class MrSpDownload {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SP_DOWNLOAD.ID
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SP_DOWNLOAD.DOWNLOAD
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    private String download;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SP_DOWNLOAD.INSTRUCTIONS
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    private String instructions;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SP_DOWNLOAD.ID
     *
     * @return the value of SP_DOWNLOAD.ID
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SP_DOWNLOAD.ID
     *
     * @param id the value for SP_DOWNLOAD.ID
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SP_DOWNLOAD.DOWNLOAD
     *
     * @return the value of SP_DOWNLOAD.DOWNLOAD
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public String getDownload() {
        return download;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SP_DOWNLOAD.DOWNLOAD
     *
     * @param download the value for SP_DOWNLOAD.DOWNLOAD
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public void setDownload(String download) {
        this.download = download == null ? null : download.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SP_DOWNLOAD.INSTRUCTIONS
     *
     * @return the value of SP_DOWNLOAD.INSTRUCTIONS
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SP_DOWNLOAD.INSTRUCTIONS
     *
     * @param instructions the value for SP_DOWNLOAD.INSTRUCTIONS
     *
     * @mbggenerated Tue Dec 06 16:40:32 CST 2016
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions == null ? null : instructions.trim();
    }
}