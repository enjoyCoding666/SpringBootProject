package com.example.demo.util;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 生成数据库对应的entity, mapper, service, controller
 * <p>
 * 运行main()方法，输入表名即可，多个表用逗号隔开
 */
public class MybatisResourcesGenerator {


    /**
     * 包名。自行修改
     */
    private static final String PACKAGE = "com.example.demo";
    /**
     * 作者。自行修改
     */
    public static final String AUTHOR = "xx";
    /**
     * 如果输出的路径不对，修改 PATH
     */
    private static final String PATH = "";

    /**
     * jdbc配置。自行修改
     */
    private static final String JDBC_MYSQL = "jdbc:mysql://数据库地址:端口/xx?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=true";
    private static final String MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER_NAME = "账号";
    private static final String PASSWORD = "密码";

    private static final String TABLE_PREFIX = "tb_";
    private static final String ENTITY_NAME = "Entity";
    private static final String ENTITY_PACKAGE = "domain";
    private static final String SERVICE_NAME = "Service";

    private static final String SERVICE_PACKAGE = "service";
    private static final String SERVICE_IMPL_PACKAGE = "service.impl";

    private static final String MAPPER_PACKAGE = "dao";
    private static final String RESOURCES_MAPPER_XML = "/src/main/resources/mapper/";


    /**
     * 生成数据库对应的entity, mapper, service, controller
     * <p>
     * 运行main()方法，输入表名即可，多个表用逗号隔开
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //获取工程根目录
        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath=" + projectPath);

        // 全局配置
        GlobalConfig gc = getGlobalConfig(projectPath);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = getSourceConfig();
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = getPackageConfig();
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = getInjectionConfig(projectPath);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = getStrategy();

        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    /**
     * 如果输出的路径不对，修改 PATH
     *
     * @param projectPath
     * @return
     */
    public static GlobalConfig getGlobalConfig(String projectPath) {
        GlobalConfig gc = new GlobalConfig();
        //如果输出的路径不对，修改 PATH
        gc.setOutputDir(projectPath + PATH + "/src/main/java");

        //作者名称
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        gc.setServiceName("%s" + SERVICE_NAME);
        gc.setEntityName("%s" + ENTITY_NAME);
        gc.setIdType(IdType.ID_WORKER);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setBaseColumnList(true);
        gc.setBaseResultMap(true);
        gc.setFileOverride(true);
        return gc;
    }

    /**
     * 数据源配置
     *
     * @return
     */
    public static DataSourceConfig getSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(JDBC_MYSQL);
        // dsc.setSchemaName("public");
        dsc.setDriverName(MYSQL_JDBC_DRIVER);
        dsc.setUsername(USER_NAME);
        dsc.setPassword(PASSWORD);
        return dsc;
    }

    /**
     * 包配置
     *
     * @return
     */
    public static PackageConfig getPackageConfig() {
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(scanner("模块名"));
        pc.setParent(PACKAGE);
        pc.setEntity(ENTITY_PACKAGE);
        pc.setService(SERVICE_PACKAGE);
        pc.setServiceImpl(SERVICE_IMPL_PACKAGE);
        pc.setMapper(MAPPER_PACKAGE);
        return pc;
    }

    /**
     * 自定义配置
     *
     * @param projectPath
     * @return
     */
    public static InjectionConfig getInjectionConfig(String projectPath) {
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + PATH + RESOURCES_MAPPER_XML
                        + tableInfo.getMapperName() + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    /**
     * 策略配置
     *
     * @return
     */
    public static StrategyConfig getStrategy() {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
//        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        strategy.setInclude(scanner("表名"));
//        strategy.setSuperEntityColumns("id_");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(TABLE_PREFIX);
        strategy.setLogicDeleteFieldName("is_delete");
        strategy.setVersionFieldName("op_version");

        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("create_time", FieldFill.INSERT));
        tableFillList.add(new TableFill("update_time", FieldFill.UPDATE));
        strategy.setTableFillList(tableFillList);
        return strategy;
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String[] scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                if (ipt.contains(",")) {
                    return ipt.split(",");
                } else {
                    return new String[]{ipt};
                }
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}


