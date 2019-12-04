import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ljp
 * @apiNote
 * @date 15:05 2019/12/4
 **/



public class CodeGeneratorTest {

    /**
     * 数据表
      */
    private  static String[] tables = new String[]{"delivery_address_info"};

    /**
     * 基类需要手动创建 -----也可以不初始化
     */
    private static String baseEntity ="com.xyhs.b2c.domain.BaseEntity";

    /**
     * 路径中在src.main.java之后的包命
     */
    private static String afterJavaPackageName ="com.xyhs.b2c";


    @Test
    public void codeGenerator()  {
        String path2 =System.getProperty("user.dir");
        System.out.println(path2);
        // 代码生成器
        AutoGenerator mpg  = initDataBase();
        initDaoCode(mpg);
        List<FileOutConfig>  focList = new ArrayList<>();
        execute(mpg,focList);
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(("请输入" + tip + "："));
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 初始化数据库
     * @return 代码生成器
     */
    private static AutoGenerator initDataBase(){
        AutoGenerator mpg  = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("ljp");
        gc.setOpen(false);
        gc.setEnableCache(false);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://182.61.42.210:3306/basecenter?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("Ljp10061087@");
        mpg.setDataSource(dsc);
        return mpg;
    }

    /**
     * Dao层代码生成
     * @param mpg 代码生成器
     */
    private static void initDaoCode(AutoGenerator mpg){
        // 包配置
        PackageConfig pc = new PackageConfig();
      //  pc.setModuleName("dao");
        pc.setParent(afterJavaPackageName);
        pc.setMapper("dao");
        pc.setEntity("domain");
        pc.setXml("xml");
        mpg.setPackageInfo(pc);
    }


    private static void execute(AutoGenerator mpg,List<FileOutConfig> focList){

        // 自定义配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(baseEntity);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 写于父类中的公共字段
        String[] array = tables;
        strategy.setInclude(array);
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        mpg.execute();
    }


}
