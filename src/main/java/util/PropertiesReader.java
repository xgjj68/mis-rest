package util;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/** *//**
 * 读取properties文件
 * @author gaojw
 *
 */
public class PropertiesReader{
	private static Logger log = Logger.getLogger(PropertiesReader.class);
    private Properties propertie;
    private FileInputStream inputFile;
    private FileOutputStream outputFile;

    /** *//**
     * 初始化Configuration类
     */
    public PropertiesReader(){
        propertie = new Properties();
    }

    /** *//**
     * 初始化Configuration类
     * @param filePath 要读取的配置文件的路径+名称,linux取不到值，改为ResourceBundle，参数filename，非路径
     */
    public PropertiesReader(String filename) throws Exception{
		log.info("load Properties:" + filename);
		propertie = new Properties();
		if(filename.startsWith("/")){
			filename = filename.substring(filename.lastIndexOf("/") + 1);
		}
		if(filename.indexOf(".properties") > 0){
			filename = filename.substring(0, filename.indexOf(".properties"));
		}
		log.info("load Properties:" + filename);
		ResourceBundle rb = ResourceBundle.getBundle(filename);
		Enumeration<String> keys = rb.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = rb.getString(key);
			propertie.setProperty(key, value);
			log.info("key:" + key + ",value:" + value);
		}

//        try {
//        	Class c = PropertiesReader.class;
//        	InputStream inputStream = null;
//        	inputStream = c.getResourceAsStream(filePath);
//        	propertie.load(inputStream);
//        	inputStream.close();
////            inputFile = new FileInputStream(filePath);
////            propertie.load(inputFile);
////            inputFile.close();
//        } catch (FileNotFoundException ex) {
//            System.out.println("读取属性文件--->失败！- 原因：文件路径错误或者文件不存在");
//            ex.printStackTrace();
//        } catch (IOException ex) {
//            System.out.println("装载文件--->失败!");
//            ex.printStackTrace();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
    }//end ReadConfigInfo(...)

    /** *//**
     * 重载函数，得到key的值
     * @param key 取得其值的键
     * @return key的值
     */
    public String getValue(String key){
        if(propertie.containsKey(key)){
            String value = propertie.getProperty(key);//得到某一属性的值
            return value;
        }
        else
            return "";
    }//end getValue(...)

    /** *//**
     * 重载函数，得到key的值
     * @param fileName properties文件的路径+文件名
     * @param key 取得其值的键
     * @return key的值
     */
    public String getValue(String fileName, String key){
        try {
            String value = "";
            inputFile = new FileInputStream(fileName);
            propertie.load(inputFile);
            inputFile.close();
            if(propertie.containsKey(key)){
                value = propertie.getProperty(key);
                return value;
            }else
                return value;
        } catch (FileNotFoundException e){
            e.printStackTrace();
            return "";
        } catch (IOException e){
            e.printStackTrace();
            return "";
        } catch (Exception ex){
            ex.printStackTrace();
            return "";
        }
    }//end getValue(...)

    /** *//**
     * 清除properties文件中所有的key和其值
     */
    public void clear(){
        propertie.clear();
    }//end clear();

    /** *//**
     * 改变或添加一个key的值，当key存在于properties文件中时该key的值被value所代替，
     * 当key不存在时，该key的值是value
     * @param key 要存入的键
     * @param value 要存入的值
     */
    public void setValue(String key, String value){
        propertie.setProperty(key, value);
    }//end setValue(...)

    /** *//**
     * 将更改后的文件数据存入指定的文件中，该文件可以事先不存在。
     * @param fileName 文件路径+文件名称
     * @param description 对该文件的描述
     */
    public void saveFile(String fileName, String description){
        try {
            outputFile = new FileOutputStream(fileName);
            propertie.store(outputFile, description);
            outputFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }//end saveFile(...)

    public static void main(String[] args){
//    	PropertiesReader rc = new PropertiesReader(".\\url.properties");//相对路径

//        String path = rc.getValue("URL");//以下读取properties文件的值
//        System.out.println("path="+rc.getValue("URL"));
//        System.out.println("ip = " + ip + "ip-test leng = " + "ip-test".length());//以下输出properties读出的值
//        System.out.println("ip's length = " + ip.length());
//        System.out.println("host = " + host);
//        System.out.println("tab = " + tab);

//        Configuration cf = new Configuration();
//        String path = cf.getValue("path.properties", "INTERFACE_PATH");
//        System.out.println("INTERFACE_PATH = " + path);
//        cf.clear();
//        cf.setValue("min", "999");
//        cf.setValue("max", "1000");
//        cf.saveFile(".\config\save.perperties", "test");

//        Configuration saveCf = new Configuration();
//        saveCf.setValue("min", "10");
//        saveCf.setValue("max", "1000");
//        saveCf.saveFile(".\config\save.perperties");

//    }//end main()

}//end class ReadConfigInfo

