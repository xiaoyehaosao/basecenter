package com.xyhs.b2c;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ljp
 * @apiNote
 * @date 12:37 2019/12/4
 **/
public class CodeGeneratorTest {


    public enum TemplateEnum {
        /**
         * 优惠券使用范围(1:平台通用类,2:店铺通用类,3:品类通用类,4:SPU使用类)
         */
        XML("xml", 1), ENTITY("entity", 2), MAPPER("mapper", 3), SERVICE("service", 4), CONTROLLER("controller", 4),SERVICE_IMPL("serviceImpl", 4);

        private int type;
        private String name;

        TemplateEnum(String name, int type) {
            this.name = name;
            this.type = type;
        }

        public int getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public String getUpName() {
            return upFirstChart(name);
        }

        public static TemplateEnum getEnumByValue(String value){
            if (StringUtils.isEmpty(value)){
                return null;
            }
            for (TemplateEnum enums : TemplateEnum.values()) {
                if (value.contains(enums.getName())) {
                    return enums;
                }
            }
            return null;
        }

    }
    private static String  upFirstChart(String name){
        String firstChar = name.substring(0,1);
        firstChar = firstChar.toUpperCase();
        return  firstChar + name.substring(1,name.length());
    }

    private static String getSuffix(TemplateEnum type,Boolean isUp,PackageConfig pc ){

        switch (type){
            case XML :
                return isUp ? TemplateEnum.XML.getUpName() : TemplateEnum.XML.getName();
            case ENTITY :
                String entity = pc.getEntity();
                if(StringUtils.isEmpty(entity)){
                    return isUp ? upFirstChart(entity) : entity;
                }
                return isUp ? TemplateEnum.ENTITY.getUpName() : TemplateEnum.ENTITY.getName();
            case MAPPER :
                String mapper = pc.getMapper();
                if(StringUtils.isEmpty(mapper)){
                    return isUp ? upFirstChart(mapper) : mapper;
                }
                return isUp ? TemplateEnum.MAPPER.getUpName() : TemplateEnum.MAPPER.getName();
            case SERVICE :
                String service = pc.getService();
                if(StringUtils.isEmpty(service)){
                    return isUp ? upFirstChart(service) : service;
                }
                return isUp ? TemplateEnum.SERVICE.getUpName() : TemplateEnum.SERVICE.getName();
            case CONTROLLER :
                String controller = pc.getController();
                if(StringUtils.isEmpty(controller)){
                    return isUp ? upFirstChart(controller) : controller;
                }
                return isUp ? TemplateEnum.CONTROLLER.getUpName() : TemplateEnum.CONTROLLER.getName();
            case SERVICE_IMPL :
                String serviceImpl = pc.getServiceImpl();
                if(StringUtils.isEmpty(serviceImpl)){
                    return isUp ? upFirstChart(serviceImpl) : serviceImpl;
                }
                return isUp ? TemplateEnum.SERVICE_IMPL.getUpName() : TemplateEnum.SERVICE_IMPL.getName();
            default:
                return "";
        }

    }




    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }


    private static AutoGenerator initMpg(){
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("jobob");
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://182.61.42.210:3306/basecenter?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("Ljp10061087@");
        mpg.setDataSource(dsc);

        // 包配置
        return mpg;
    }
    private static PackageConfig initPackage(){
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.xyhs.b2c");
        pc.setEntity("domain");
        pc.setMapper("dao");
        return pc;
    }

    /**
     * 添加模板配置
     * @param focList 配置队列
     * @param templatePath 模板路径
     * @param filePath 输出文件路径
     * @param pc 包配置
     * @return 配置队列
     */
    private static List<FileOutConfig> AddFocList( List<FileOutConfig> focList,String templatePath,String filePath,PackageConfig pc ){

        if(StringUtils.isEmpty(templatePath)){
            return new ArrayList<>();
        }
        String suffixPath="";
        String upFileSuffix = "";

        if(templatePath.contains(TemplateEnum.XML.getName())){
            suffixPath = "/src/main/resources/mapper";
        }else {
            suffixPath = "/src/main/java/";
            String parent = pc.getParent();
            parent = parent.replace(".","/");
            suffixPath = suffixPath + parent;
            TemplateEnum templateEnum = TemplateEnum.getEnumByValue(templatePath);
            String fileSuffix = getSuffix(templateEnum,false,pc);
            upFileSuffix = getSuffix(templateEnum,true,pc);
        }

        // 自定义配置会被优先输出
        String finalSuffixPath = suffixPath;
        String finalUpFileSuffix = upFileSuffix;
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                String result = filePath + finalSuffixPath+ "/" + tableInfo.getEntityName() + finalUpFileSuffix + StringPool.DOT_XML;
                return  result;
            }
        });
        return focList;
    }


    private static void templateConfig(AutoGenerator mpg, PackageConfig pc){
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 velocity
        String templatePath = "/templates/entity.java.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        AddFocList(focList,templatePath,"F:/xyhs/basecenter/basecenter-dao",pc);
      /*  // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return  "F:/xyhs/basecenter/basecenter-dao/src/main/resources/mapper/"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        String entityTemplate = "/templates/entity.java.vm";
        focList.add(new FileOutConfig(entityTemplate) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return  "F:/xyhs/basecenter/basecenter-dao/src/main/java/com/xyhs/b2c/domain"
                        + "/" + tableInfo.getEntityName()  + StringPool.DOT_JAVA;
            }
        });

        String mapperTemplate = "/templates/mapper.java.vm";
        focList.add(new FileOutConfig(mapperTemplate) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                tableInfo.setMapperName(tableInfo.getEntityName() +"Dao");
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return  "F:/xyhs/basecenter/basecenter-dao/src/main/java/com/xyhs/b2c/dao"
                        + "/" + tableInfo.getEntityName() +"Dao" + StringPool.DOT_JAVA;
            }
        });*/

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        templateConfig.setEntity(null);
        templateConfig.setController(null);
        templateConfig.setServiceImpl(null);
        templateConfig.setService(null);
        templateConfig.setMapper(null);
        mpg.setTemplate(templateConfig);
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = initMpg();
        PackageConfig pc = initPackage();
        mpg.setPackageInfo(pc);
        templateConfig(mpg, pc);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.xyhs.b2c.domain.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.execute();
    }
}
