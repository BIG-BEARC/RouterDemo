package com.example.lib_common.router;

/**
 * 应用模块: 组件化路由
 * @Description  用于在组件化开发中,利用ARouter 进行Activity跳转的统一路径注册, 注册时请写好注释、标注界面功能业务
 * @Author chuxiong
 * @Time 2021/6/9 4:54 PM
 */
public interface RouterActivityPath {
    class ModuleOne {
        private static final String MODULE_ONE = "/module_one";

        public static final String ONE = MODULE_ONE+ "/OneActivity";
    }
    class ModuleTwo{
        public static final String MODULE_TWO = "/module_two";
        public static final String MODULE_MAIN = MODULE_TWO+ "/main";
        public static final String MODULE_TEST= MODULE_TWO+ "/test";
    }

    class  Main{
        public static final String MODULE_MAIN = "/module_main";
        public static final String MODULE_LOSS = MODULE_MAIN + "/loss_activity";
    }
}
