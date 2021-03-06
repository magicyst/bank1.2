package com.cx.bank.util;

import com.cx.bank.dao.BankDaoInterface;

import java.util.HashMap;

/**
 * @version bak1.5
 * Created by Administrator on 2018/7/3.
 */
public class Dao {

    private String Deflult; //默认的数据源

    private DataSrc dataSrc; //数据源的配置

    private String instance; //dao操作的的实现类

    /**
     * 构造方法
     */
    public Dao() {

    }

    /**
     * 数据源配置 内部类
     */
    public class DataSrc{

        private HashMap<String,String> properties; //配置健值对

        /**
         * 构造方法
         */
        public DataSrc(){}


        /**
         *seter
         * @param properties 配置
         */
        public void setProperties(HashMap<String,String> properties){

            this.properties = properties;
        }

        /**
         * geter
         * @return 配置集合
         */
        public HashMap<String, String> getProperties(){

            return this.properties;
        }

    }


    /*
    geter and seter
     */
    public String getDeflult() {
        return Deflult;
    }

    public void setDeflult(String deflult) {
        Deflult = deflult;
    }

    public DataSrc getDataSrc() {
        return dataSrc;
    }

    public void setDataSrc(DataSrc dataSrc) {
        this.dataSrc = dataSrc;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    /**
     * 获取dao实例 依据bankconfig.xml的dao配置
     * @return dao实现
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public BankDaoInterface getInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        return (BankDaoInterface) Class.forName(instance).newInstance();
    }

    public static void main(String[] args) {

        try {
            System.out.println(new BankConfigure().getDao().getInstance());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
