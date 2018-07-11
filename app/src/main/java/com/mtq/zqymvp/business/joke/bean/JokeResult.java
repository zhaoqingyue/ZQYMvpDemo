package com.mtq.zqymvp.business.joke.bean;

import java.util.ArrayList;

/**
 * Created by zhaoqy on 2018/7/9.
 */
/**
 * {
 *   "status": "0",
 *   "msg": "ok",
 *   "result": {
 *      "total": "76440",
 *      "pagenum": "10",
 *       "pagesize": "3",
 *      "list": [ {
 *           "content": "想知道下面那位哥们生死如何了",
 *           "addtime": "2014-10-14 07:02:18",
 *           "url": "http:\/\/m.kaixinhui.com\/detail-5049.html"
 *           }, {
 *           "content": "这事你咋看？:最后的神回复又亮了！",
 *           "addtime": "2014-10-14 08:13:31",
 *           "url": "http:\/\/m.kaixinhui.com\/detail-5050.html"
 *           }
 *       ]
 *    }
 * }
 */
public class JokeResult {

    public int total;

    public int pagenum;

    public int pagesize;

    public ArrayList<JokeInfo> list;
}
