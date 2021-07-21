package com.example.lib_common.router;

public interface RouterExtrasFlag {

    int FLAG_LOGIN = 0X01;
    int FLAG_VIP = FLAG_LOGIN << 1; // 左移1位
    int FLAG_FLUTTER = FLAG_VIP << 1; // Flutter容器路由标志
    int FLAG_WEEX = FLAG_FLUTTER << 1;// Weex容器路由标志

}